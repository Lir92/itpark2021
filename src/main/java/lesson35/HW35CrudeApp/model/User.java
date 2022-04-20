package lesson35.HW35CrudeApp.model;

import lesson35.HW35CrudeApp.model.type.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER") // БД с данными пользователя.
@NamedEntityGraph(name = "User.role", attributeNodes = @NamedAttributeNode("role"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "login", nullable = false)
    private String login;

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    @NotEmpty
    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private Status status; // статус пользователя

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role; // роль пользователя
}