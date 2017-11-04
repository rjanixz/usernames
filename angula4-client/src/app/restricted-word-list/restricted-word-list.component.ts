import { Component, EventEmitter, Input, Output } from '@angular/core';
import { RestrictedWord } from '../restricted-word';

@Component({
  selector: 'app-restricted-word-list',
  templateUrl: './restricted-word-list.component.html',
  styleUrls: ['./restricted-word-list.component.css']
})
export class RestrictedWordListComponent{

  @Input()
  words: RestrictedWord[];

  @Output()
  remove: EventEmitter<RestrictedWord> = new EventEmitter();

  constructor() { }

  onRemoveWord(word: RestrictedWord) {
    this.remove.emit(word);
  }

}
