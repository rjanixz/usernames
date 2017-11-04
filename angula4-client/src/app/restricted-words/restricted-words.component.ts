import { Component, OnInit } from '@angular/core';
import { RestrictedWordDataService } from '../restricted-word-data.service';
import { RestrictedWord } from '../restricted-word';

@Component({
  selector: 'app-restricted-words',
  templateUrl: './restricted-words.component.html',
  styleUrls: ['./restricted-words.component.css'],
  providers: [RestrictedWordDataService]
})
export class RestrictedWordsComponent implements OnInit {

  words: RestrictedWord[] = [];
  
    constructor(
      private restrictedWordDataService: RestrictedWordDataService
    ) { }
  
    public ngOnInit() {
      this.restrictedWordDataService
        .getAllWords()
        .subscribe(
          (words) => {
            this.words = words;
          }
        );
    }
  
    onAddWord(word) {
      this.restrictedWordDataService
        .addWord(word)
        .subscribe(
          (newWord) => {
            this.words = this.words.concat(newWord)
          }
        );
    }
  
    onRemoveWord(word) {
      this.restrictedWordDataService
        .deleteWordById(word.id)
        .subscribe(
          (_) => {
            this.words = this.words.filter((u) => u.id !== word.id);
          }
        );
    }

}
