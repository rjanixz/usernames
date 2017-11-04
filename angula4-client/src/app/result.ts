import { User } from './user';

export class Result {
    user: User;
    success: boolean = true;
    suggestions: string[] = [];

    constructor(values: Object = {}) {
        Object.assign(this, values);
    }
}
