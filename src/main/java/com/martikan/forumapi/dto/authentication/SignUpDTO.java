package com.martikan.forumapi.dto.authentication;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * DTO for {@link com.martikan.restaurantapi.domain.user.User} registration.
 */
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SignUpDTO implements Serializable {

    private static final long serialVersionUID = 1712649431303706280L;

    @EqualsAndHashCode.Include
    @Size(max = 255)
    @NotBlank
    @Email
    private String email;

    @ToString.Exclude
    @Size(min = 6, max = 16)
    private String password;

    @Size(max = 100)
    @NotBlank
    private String firstName;

    @Size(max = 100)
    @NotBlank
    private String lastName;

    @Size(max = 20)
    private String phoneNumber;

}