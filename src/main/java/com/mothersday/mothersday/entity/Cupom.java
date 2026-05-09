package com.mothersday.mothersday.entity;
import com.mothersday.mothersday.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "cupom")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "titulo")
    String titulo;

    @Column(name = "description")
    String description;

    @Column(name = "icone")
    String icone;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    Status status;

}
