package ed.lab.ed1final.controller;

import com.sun.net.httpserver.HttpsServer;
import ed.lab.ed1final.service.TrieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trie")
public class TrieController {
    public TrieService service;

    @GetMapping("/{word}/count")
    public ResponseEntity<Integer> getWordCount(@PathVariable String word) {
        try {
            return new ResponseEntity<>(service.getWordCount(word), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{word}/prefix")
    public ResponseEntity<Integer> getPrefixCount(@PathVariable String word) {
        try {
            return new ResponseEntity<>(service.getPrefixNumber(word), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/{word}")
    public ResponseEntity<Void> insertWord(@PathVariable String word) {
        try {
            service.addWord(word);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/trie/{word}")
    public ResponseEntity<Void> deleteWord(@PathVariable String word) {
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
