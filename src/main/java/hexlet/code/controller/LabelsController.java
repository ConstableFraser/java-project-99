package hexlet.code.controller;

import hexlet.code.dto.label.LabelCreateDTO;
import hexlet.code.dto.label.LabelDTO;
import hexlet.code.dto.label.LabelUpdateDTO;
import hexlet.code.service.LabelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LabelsController {

    @Autowired
    private LabelService labelService;

    @GetMapping("/labels")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<LabelDTO>> index() {
        var labels = labelService.getAll();

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(labels.size()))
                .body(labels);
    }

    @PostMapping("/labels")
    @ResponseStatus(HttpStatus.CREATED)
    public LabelDTO create(@Valid @RequestBody LabelCreateDTO labelCreateDTO) {
        return labelService.create(labelCreateDTO);
    }

    @GetMapping("/labels/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LabelDTO show(@PathVariable Long id) {
        return labelService.show(id);
    }

    @PutMapping("/labels/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LabelDTO update(@Valid @RequestBody LabelUpdateDTO labelData, @PathVariable Long id) {
        return labelService.update(labelData, id);
    }

    @DeleteMapping("/labels/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        labelService.destroy(id);
    }
}
