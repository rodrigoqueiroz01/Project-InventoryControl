package inventory.control.http.controller;

import inventory.control.http.dto.request.ConveyorRequest;
import inventory.control.http.dto.response.ConveyorResponse;
import inventory.control.http.mapper.ConveyorMapper;
import inventory.control.service.ConveyorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/conveyor")
@AllArgsConstructor
@Validated
public class ConveyorController {

    private final ConveyorService conveyorService;

    @PostMapping
    public ResponseEntity<ConveyorResponse> save(@Valid @RequestBody ConveyorRequest conveyorRequest) {
        return ResponseEntity
                .ok()
                .body(ConveyorMapper.toResponse(conveyorService.save(ConveyorMapper.toModel(conveyorRequest))));
    }

    @GetMapping("/{conveyorId}")
    public ResponseEntity<ConveyorResponse> findById(@PathVariable String conveyorId) {
        return ResponseEntity
                .ok()
                .body(ConveyorMapper.toResponse(conveyorService.findById(UUID.fromString(conveyorId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ConveyorResponse>> findAll() {
        return ResponseEntity
                .ok()
                .body(ConveyorMapper.toResponseList(conveyorService.findAll()));
    }

    @PutMapping("/{conveyorId}")
    public ResponseEntity<ConveyorResponse> update(@PathVariable String conveyorId, @RequestBody ConveyorRequest conveyorRequest) {
        return ResponseEntity
                .ok()
                .body(ConveyorMapper.toResponse(conveyorService.update(ConveyorMapper.toModel(conveyorRequest), UUID.fromString(conveyorId))));
    }

    @DeleteMapping("/{conveyorId}")
    public ResponseEntity<UUID> delete(@PathVariable String conveyorId) {
        return ResponseEntity
                .ok()
                .body(conveyorService.delete(UUID.fromString(conveyorId)));
    }

}
