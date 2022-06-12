package com.martikan.forumapi.dto.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO to send email availability.
 */
@Builder
@Data
@EqualsAndHashCode
public class EmailAvailabilityDTO implements Serializable {

    private static final long serialVersionUID = 8775368935049642738L;

    @NotNull
    private boolean emailAvailable;

}