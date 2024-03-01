package com.desafio.attus.Desafio.Attus.controller;

import com.desafio.attus.Desafio.Attus.model.Person;
import com.desafio.attus.Desafio.Attus.service.PersonService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/persons")
@Api(tags = "Pessoas", description = "Operações relacionadas a pessoas")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ApiOperation("Cria uma nova pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa criada com sucesso"),
            @ApiResponse(code = 400, message = "Requisição inválida")
    })
    public Person createPerson(
            @ApiParam(value = "ID da pessoa") @RequestParam String id,
            @ApiParam(value = "Nome completo da pessoa") @RequestParam String fullName,
            @ApiParam(value = "Data de nascimento da pessoa") @RequestParam Date dateOfBirth) {
        return personService.createPerson(id, fullName, dateOfBirth);
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtém uma pessoa pelo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa encontrada"),
            @ApiResponse(code = 404, message = "Pessoa não encontrada")
    })
    public Person getPerson(
            @ApiParam(value = "ID da pessoa") @PathVariable String id) {
        return personService.getPerson(id);
    }

    @PutMapping
    @ApiOperation("Atualiza uma pessoa existente")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Pessoa atualizada com sucesso"),
            @ApiResponse(code = 404, message = "Pessoa não encontrada")
    })
    public void updatePerson(
            @ApiParam(value = "Pessoa atualizada") @RequestBody Person updatedPerson) {
        personService.updatePerson(updatedPerson);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui uma pessoa pelo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Pessoa excluída com sucesso"),
            @ApiResponse(code = 404, message = "Pessoa não encontrada")
    })
    public void deletePerson(
            @ApiParam(value = "ID da pessoa") @PathVariable String id) {
        personService.deletePerson(id);
    }
}
