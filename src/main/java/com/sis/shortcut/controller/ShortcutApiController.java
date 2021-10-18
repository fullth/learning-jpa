package com.sis.shortcut.controller;

import com.sis.shortcut.dto.ShortcutRequestDTO;
import com.sis.shortcut.dto.ShortcutResponseDTO;
import com.sis.shortcut.service.ShortcutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShortcutApiController {

    private final ShortcutService shortcutService;

    /**
     * Search shortcut
     * */
    @GetMapping("/v1/shortcut")
    public List<ShortcutResponseDTO> findAll() {
        return shortcutService.findAll();
    }

    /**
     * Resister shortcut
     * */
    @PostMapping("/v1/shortcut")
    public String resisterShortcut(@RequestBody final ShortcutRequestDTO params) {
        return shortcutService.save(params);
    }

    /**
     * Patch shortcut
     * */
    @PatchMapping("v1/shortcut/{id}")
    public List<ShortcutResponseDTO> updateShortcut (@PathVariable final Long id, @RequestBody final ShortcutRequestDTO param) {
        return shortcutService.update(id, param);
    }

    /**
     * Delete shortcut
     * */
    @DeleteMapping("v1/shortcut/{id}")
    public void deleteShortcut (@PathVariable final Long id) {
        shortcutService.deletePost(id);
    }

}
