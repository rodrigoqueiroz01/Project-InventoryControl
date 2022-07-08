package inventory.control.http.controller;

import inventory.control.http.dto.request.ProviderRequest;
import inventory.control.http.dto.response.ProviderResponse;
import inventory.control.http.dto.mapper.ProviderMapper;
import inventory.control.service.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/provider")
@AllArgsConstructor
@Validated
public class ProviderController {

    private final ProviderService providerService;

    @PostMapping
    public ResponseEntity<ProviderResponse> save(@Valid @RequestBody ProviderRequest providerRequest) {
        return ResponseEntity
                .ok()
                .body(ProviderMapper.toResponse(providerService.save(ProviderMapper.toModel(providerRequest))));
    }

    @GetMapping("/{providerId}")
    public ResponseEntity<ProviderResponse> findById(@PathVariable String providerId) {
        return ResponseEntity
                .ok()
                .body(ProviderMapper.toResponse(providerService.findById(UUID.fromString(providerId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProviderResponse>> findAll() {
        return ResponseEntity
                .ok()
                .body(ProviderMapper.toResponseList(providerService.findAll()));
    }

    @PutMapping("/{providerId}")
    public ResponseEntity<ProviderResponse> update(@PathVariable String providerId, @RequestBody ProviderRequest providerRequest) {
        return ResponseEntity
                .ok()
                .body(ProviderMapper.toResponse(providerService.update(ProviderMapper.toModel(providerRequest), UUID.fromString(providerId))));
    }

    @DeleteMapping("/{providerId}")
    public ResponseEntity<UUID> delete(@PathVariable String providerId) {
        return ResponseEntity
                .ok()
                .body(providerService.delete(UUID.fromString(providerId)));
    }

}
