export class Article {
    id: number;
    title: string;
    category: string;
    
    constructor(id: number, title: string, category: string) {
        this.id = id;
        this.title = title;
        this.category = category;
    }
}
