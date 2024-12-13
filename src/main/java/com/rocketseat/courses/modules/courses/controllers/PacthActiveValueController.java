package com.rocketseat.courses.modules.courses.controllers;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.courses.modules.courses.dto.UpdateActiveRequestDTO;
import com.rocketseat.courses.modules.courses.useCases.PacthActiveValueUseCase;
import com.rocketseat.courses.modules.courses.utils.ApiRouters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(ApiRouters.COURSES)
public class PacthActiveValueController {
  @Autowired
  private PacthActiveValueUseCase pacthActiveValueUseCase;
  @PatchMapping("/{id}")
  @Tag(name = "Cursos",description = "Atualiza o valor de ativo de um curso pelo seu id")
    @ApiResponses({
        @ApiResponse(responseCode = "204")
    })
  public ResponseEntity<?> handle(@RequestBody UpdateActiveRequestDTO request,@PathVariable("id") UUID id) {
    try {
      this.pacthActiveValueUseCase.execute(request,id);
      return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
