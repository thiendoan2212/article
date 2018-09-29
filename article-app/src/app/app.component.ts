import { Component } from '@angular/core';
import { ArticleService } from './service/article.service';
import { Article } from './model/article';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  data: any;
  logs: string[] = [];

  selectedArticle: Article;

  constructor(private articleServicle: ArticleService) {
    this.clearForm();
    this.loadArticle();
  }

  clearForm() {
    this.selectedArticle = {
      id: 0,
      title: "",
      category: ""
    }
  }

  loadArticle() {
    this.articleServicle.getAllArticle().subscribe(res => {
      if (res.code == 1) {
        this.data = res.data;
        if (this.data.length > 1) {
          this.selectedArticle = this.data[0];
        }
        this.logs.unshift("[" + new Date().toLocaleString() + "] " + res.message);
      }
    })
  }

  addArticle() {
    this.articleServicle.postArticle(this.selectedArticle).subscribe(res => {
      if (res.code != -1) this.logging(res.message);
    })
  }

  updateArticle() {
    this.articleServicle.putArticle(this.selectedArticle.id, this.selectedArticle).subscribe(res => {
      if (res.code != -1) this.logging(res.message);
    })
  }

  deleteAritcle(id: number) {
    this.articleServicle.deleteArticle(id).subscribe(res => {
      if (res.code != -1) this.logging(res.message);
    })
  }

  logging(message) {
    this.loadArticle();
    this.logs.unshift("[" + new Date().toLocaleString() + "] " + message);
  }
}
