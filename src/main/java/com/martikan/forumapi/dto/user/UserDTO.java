package com.martikan.forumapi.dto.user;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO for {@link com.martikan.restaurantapi.domain.user.User} entity.
 */
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1537744993974704025L;

    @EqualsAndHashCode.Include
    private Long id;

    @Size(max = 255)
    @NotBlank
    @Email
    private String email;

    @Size(max = 100)
    @NotBlank
    private String firstName;

    @Size(max = 100)
    @NotBlank
    private String lastName;

    @Size(max = 20)
    private String phone;

}