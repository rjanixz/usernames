import { Component, Input, Output, EventEmitter } from '@angular/core';
import { RestrictedWord } from '../restricted-word';

@Component({
  selector: 'app-restricted-word-list-item',
  templateUrl: './restricted-word-list-item.component.html',
  styleUrls: ['./restricted-word-list-item.component.css']
})
export class RestrictedWordListItemComponent {

  @Input() word: RestrictedWord;
  
  @Output()
  remove: EventEmitter<RestrictedWord> = new EventEmitter();

  constructor() { }

  removeWord(word: RestrictedWord) {
    this.remove.emit(word);
  }

}
