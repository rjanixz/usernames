import { Injectable } from '@angular/core';
import { RestrictedWord } from './restricted-word';
import { ApiService } from './api.service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RestrictedWordDataService {

  words: RestrictedWord[] = [];

  constructor(
    private api: ApiService
  ) { }

  addWord(word: RestrictedWord): Observable<RestrictedWord> {
    return this.api.createWord(word);
  }
  
  deleteWordById(id: number): Observable<RestrictedWord> {
    return this.api.deleteWordById(id);
  }

  getAllWords(): Observable<RestrictedWord[]> {
    return this.api.getAllWords();
  }

  getWordById(id: number): Observable<RestrictedWord> {
    return this.api.getWordById(id);
  }
}
