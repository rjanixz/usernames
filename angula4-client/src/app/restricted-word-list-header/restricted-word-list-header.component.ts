import { Component, Output, EventEmitter } from '@angular/core';
import { RestrictedWord } from '../restricted-word';

@Component({
  selector: 'app-restricted-word-list-header',
  templateUrl: './restricted-word-list-header.component.html',
  styleUrls: ['./restricted-word-list-header.component.css']
})
export class RestrictedWordListHeaderComponent {

  newWord: RestrictedWord = new RestrictedWord();
  
  @Output()
  add: EventEmitter<RestrictedWord> = new EventEmitter();

  constructor() { }

  addWord() {
    this.add.emit(this.newWord);
    this.newWord = new RestrictedWord();
  }

}
