package com.titanic.buckpal.account.adapter.out.persistence;

import java.lang.annotation.Target;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO(Account)와 다르게 Entity를 따로 만든다.
 */
@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

}
