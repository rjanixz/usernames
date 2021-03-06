import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-suggestion-list',
  templateUrl: './suggestion-list.component.html',
  styleUrls: ['./suggestion-list.component.css']
})
export class SuggestionListComponent {

  @Input()
  suggestions: string[];

  constructor() { }

}
