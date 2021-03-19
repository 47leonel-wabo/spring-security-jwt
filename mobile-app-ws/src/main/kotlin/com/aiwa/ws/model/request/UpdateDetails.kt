package com.aiwa.ws.model.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class UpdateDetails(@NotBlank @NotNull val firstName: String, @NotBlank @NotNull val lastName: String)