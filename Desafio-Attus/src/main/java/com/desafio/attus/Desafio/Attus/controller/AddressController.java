package com.desafio.attus.Desafio.Attus.controller;

import com.desafio.attus.Desafio.Attus.model.Address;
import com.desafio.attus.Desafio.Attus.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons/{personId}/addresses")
@Api(tags = "Endereços", description = "Operações relacionadas a endereços de pessoas")
public class AddressController {
    private final PersonService personService;

    public AddressController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ApiOperation("Cria um novo endereço para uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço criado com sucesso"),
            @ApiResponse(code = 400, message = "Requisição inválida")
    })
    public Address createAddress(
            @ApiParam(value = "ID da pessoa") @PathVariable String personId,
            @ApiParam(value = "ID do endereço") @RequestParam String id,
            @ApiParam(value = "Rua") @RequestParam String street,
            @ApiParam(value = "CEP") @RequestParam String cep,
            @ApiParam(value = "Estado") @RequestParam String state) {
        return personService.createAddress(personId, id, street, cep, state);
    }

    @PutMapping
    @ApiOperation("Atualiza um endereço existente de uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço atualizado com sucesso"),
            @ApiResponse(code = 404, message = "Endereço não encontrado")
    })
    public void updateAddress(
            @ApiParam(value = "ID da pessoa") @PathVariable String personId,
            @ApiParam(value = "Endereço atualizado") @RequestBody Address updatedAddress) {
        personService.updateAddress(personId, updatedAddress);
    }

    @DeleteMapping("/{addressId}")
    @ApiOperation("Exclui um endereço de uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Endereço excluído com sucesso"),
            @ApiResponse(code = 404, message = "Endereço não encontrado")
    })
    public void deleteAddress(
            @ApiParam(value = "ID da pessoa") @PathVariable String personId,
            @ApiParam(value = "ID do endereço") @PathVariable String addressId) {
        personService.deleteAddress(personId, addressId);
    }
}
