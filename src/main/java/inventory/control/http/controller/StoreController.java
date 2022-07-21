package inventory.control.http.controller;

import inventory.control.http.dto.request.StoreRequest;
import inventory.control.http.dto.response.StoreResponse;
import inventory.control.http.mapper.StoreMapper;
import inventory.control.model.StoreModel;
import inventory.control.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stores")
@AllArgsConstructor
@Validated
public class StoreController {

    private final StoreService storeService;

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
    ResponseEntity<Page<StoreModel>> findAll(Pageable pageable,
                                             @RequestParam(name = "district", required = false) String district) {
        return ResponseEntity.ok().body(storeService.findAll(pageable, district));
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
