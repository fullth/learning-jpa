package com.sis.shortcut;

import com.sis.exception.CustomException;
import com.sis.exception.ErrorCode;
import com.sis.shortcut.entity.Shortcut;
import com.sis.shortcut.entity.ShortcutRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ShortcutTest {

    @Autowired
    ShortcutRepository shortcutRepository;

    @Test
    void findShortcutById() {
        shortcutRepository.findById((long) 1);
    }

    @Test
    void findAll() {
        long shortcutCount = shortcutRepository.count();

        List<Shortcut> shortcutList = shortcutRepository.findAll();
    }

    @Test
    void updateShortcut() {
        Shortcut shortcut = shortcutRepository.findById((long) 2).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        shortcut.updateShortcut("잘라내기", "ctrl+x", "tester");
    }
}



