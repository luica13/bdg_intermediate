package am.bdg.intermediate_group_2_W_S.airport_management.controller;

import am.bdg.intermediate_group_2_W_S.airport_management.service.AddressService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.AddressDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.PassengerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        try {
            AddressDto addressDto = addressService.get(id);
            return ResponseEntity.ok(addressDto);
        } catch (EntityNotFoundException ex) {
            return new  ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AddressDto addressDto) {
        addressDto = addressService.create(addressDto);
        return ResponseEntity.ok(addressDto);
    }

    @GetMapping
    public ResponseEntity<?> all() {
        Set<AddressDto> all = addressService.getAll();
        if (all.isEmpty()) return new ResponseEntity<>("not yet addresses", HttpStatus.NO_CONTENT);
        else return ResponseEntity.ok(all);
    }

    @GetMapping("/page")
    public ResponseEntity<?> getByPage(@RequestParam Integer limit,
                                       @RequestParam Integer offset,
                                       @RequestParam(required = false, value = "sort_key") String sortKey) {
        List<AddressDto> certainCrowd = addressService.getCertainCrowd(limit, offset, sortKey);
        if (certainCrowd.isEmpty()) return new ResponseEntity<>("not yet addresses", HttpStatus.NO_CONTENT);
        else return ResponseEntity.ok(certainCrowd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody @Valid AddressDto addressDto) {
        AddressDto edit = addressService.edit(addressDto);
        return ResponseEntity.ok(edit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            addressService.removeById(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/passengers/{id}")
    public ResponseEntity<?> getPassengersByTripId(@PathVariable Long id) {
        try {
            AddressDto addressDto = addressService.get(id);
            Set<PassengerDto> addressPassengers = addressService.getAddressPassengers(addressDto);
            if (addressPassengers.isEmpty())
                return new ResponseEntity<>(String.format("address by id: %s doesnt have passengers", addressDto.getId()), HttpStatus.NO_CONTENT);
            return ResponseEntity.ok(addressPassengers);
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
