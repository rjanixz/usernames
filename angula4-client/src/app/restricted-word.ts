export class RestrictedWord {
    id: number;
    word: string = '';

    constructor(values: Object = {}) {
        Object.assign(this, values);
    }
}
