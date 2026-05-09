package com.mothersday.mothersday.service;
import com.mothersday.mothersday.entity.Cupom;
import com.mothersday.mothersday.repository.CupomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CupomService {

    private final CupomRepository repository;

    public CupomService(CupomRepository repository) {
        this.repository = repository;
    }

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.chat.id}")
    private String chatId;

    public Cupom createService(Cupom cupom) {
        return repository.save(cupom);
    }

    public List<Cupom> listedService() {
        return repository.findAll();
    }

    public void deleteService(Long id) {
        Cupom cupom = repository.findById(id).orElse(null);

        if (cupom != null) {
            enviarNotificacaoTelegram(cupom.getTitulo());

            repository.deleteById(id);
        }
    }

    private void enviarNotificacaoTelegram(String nomeDoCupom) {

        String message = "🚨 ALERTA! A mamãe acabou de resgatar o cupom: " + nomeDoCupom;

        String urlTelegram = "https://api.telegram.org/bot" + botToken +
                "/sendMessage?chat_id=" + chatId +
                "&text=" + message;
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getForObject(urlTelegram, String.class);
            System.out.println("Notificação enviada com sucesso pro filho!");
        } catch (Exception e) {
            System.err.println("Erro ao chamar o Telegram: " + e.getMessage());
        }
    }

}
