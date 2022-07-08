package inventory.control.http.controller;

import inventory.control.http.dto.request.EntryItemRequest;
import inventory.control.http.dto.response.EntryItemResponse;
import inventory.control.http.dto.mapper.EntryItemMapper;
import inventory.control.service.EntryItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/entryItem")
@AllArgsConstructor
@Validated
public class EntryItemController {

    private final EntryItemService entryItemService;

    @PostMapping
    public ResponseEntity<EntryItemResponse> save(@Valid @RequestBody EntryItemRequest entryItemRequest) {
        return ResponseEntity
                .ok()
                .body(EntryItemMapper.toResponse(entryItemService.save(EntryItemMapper.toModel(entryItemRequest))));
    }

    @GetMapping("/{entryItemId}")
    public ResponseEntity<EntryItemResponse> findById(@PathVariable String entryItemId) {
        return ResponseEntity
                .ok()
                .body(EntryItemMapper.toResponse(entryItemService.findById(UUID.fromString(entryItemId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EntryItemResponse>> findAll() {
        return ResponseEntity
                .ok()
                .body(EntryItemMapper.toResponseList(entryItemService.findAll()));
    }

    @PutMapping("/{entryItemId}")
    public ResponseEntity<EntryItemResponse> update(@PathVariable String entryItemId, @RequestBody EntryItemRequest entryItemRequest) {
        return ResponseEntity
                .ok()
                .body(EntryItemMapper.toResponse(entryItemService.update(EntryItemMapper.toModel(entryItemRequest), UUID.fromString(entryItemId))));
    }

    @DeleteMapping("/{entryItemId}")
    public ResponseEntity<UUID> delete(@PathVariable String entryItemId) {
        return ResponseEntity
                .ok()
                .body(entryItemService.delete(UUID.fromString(entryItemId)));
    }

}
