package modelo;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente extends AuditoriaApp { //[cite: 1]
    @Column(nullable = false) //[cite: 1]
    private String cuitCuil;
    @Column(nullable = false) //[cite: 1]
    private String denominacion;

    @OneToOne //[cite: 1]
    @JoinColumn(nullable = false) //[cite: 1]
    private Contacto contacto;

    @OneToOne //[cite: 1]
    @JoinColumn(nullable = false) //[cite: 1]
    private Domicilio domicilio;
}
