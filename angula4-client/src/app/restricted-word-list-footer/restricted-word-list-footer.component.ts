import { Component, Input } from '@angular/core';
import { RestrictedWord } from '../restricted-word';

@Component({
  selector: 'app-restricted-word-list-footer',
  templateUrl: './restricted-word-list-footer.component.html',
  styleUrls: ['./restricted-word-list-footer.component.css']
})
export class RestrictedWordListFooterComponent {

  @Input()
  words: RestrictedWord[];

  constructor() { }

}
