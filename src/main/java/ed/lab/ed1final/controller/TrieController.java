package ed.lab.ed1final.controller;

import com.sun.net.httpserver.HttpsServer;
import ed.lab.ed1final.model.GetPrefixCountRequest;
import ed.lab.ed1final.model.GetWordCountRequest;
import ed.lab.ed1final.service.TrieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trie")
public class TrieController {
    public TrieService service;

    public TrieController(TrieService service) {
        this.service = service;
    }

    @GetMapping("/{word}/count")
    public ResponseEntity<GetWordCountRequest> getWordCount(@PathVariable String word) {
        if (word.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (idx < 0 || idx > 25) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<>(new GetWordCountRequest(word, service.countWordsEqualTo(word)), HttpStatus.OK);
    }

    @GetMapping("/{word}/prefix")
    public ResponseEntity<GetPrefixCountRequest> getPrefixCount(@PathVariable String word) {
        if (word.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (idx < 0 || idx > 25) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<>(new GetPrefixCountRequest(word, service.countWordsStartingWith(word)), HttpStatus.OK);
    }

    @PostMapping("/{word}")
    public ResponseEntity<Void> insertWord(@PathVariable String word) {
        if (word.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (idx < 0 || idx > 25) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        service.insertWord(word);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/{word}")
    public ResponseEntity<Void> deleteWord(@PathVariable String word) {
        try {
            service.eraseWord(word);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
