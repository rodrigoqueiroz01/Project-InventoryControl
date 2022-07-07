package inventory.control.controller;

import inventory.control.dto.request.StoreRequest;
import inventory.control.dto.response.StoreResponse;
import inventory.control.dto.mapper.StoreMapper;
import inventory.control.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/store")
@AllArgsConstructor
@Validated
public class StoreController {

    private StoreService storeService;

    @PostMapping
    public ResponseEntity<StoreResponse> save(@Valid @RequestBody StoreRequest storeRequest) {
        return ResponseEntity.ok()
                .body(StoreMapper.toResponse(storeService.save(StoreMapper.toModel(storeRequest))));
    }

    @GetMapping("/{storeCod}")
    public ResponseEntity<StoreResponse> findByCod(@PathVariable String storeCod) {
        return ResponseEntity.ok()
                .body(StoreMapper.toResponse(storeService.findByCod(UUID.fromString(storeCod))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StoreResponse>> findAll() {
        return ResponseEntity.ok()
                .body(StoreMapper.toResponseList(storeService.findAll()));
    }

    @PutMapping("/{storeCod}")
    public ResponseEntity<StoreResponse> update(@PathVariable String storeCod, @RequestBody StoreRequest storeRequest) {
        return ResponseEntity.ok()
                .body(StoreMapper.toResponse(storeService.update(StoreMapper.toModel(storeRequest), UUID.fromString(storeCod))));
    }

    @DeleteMapping("/{storeCod}")
    public ResponseEntity<UUID> delete(@PathVariable String storeCod) {
        return ResponseEntity.ok()
                .body(storeService.delete(UUID.fromString(storeCod)));
    }

}
