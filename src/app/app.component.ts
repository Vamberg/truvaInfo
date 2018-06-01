import { Component } from '@angular/core';
import { Message } from 'primeng/components/common/api'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  msgs: Message[] = [];
  nome: string;

  private showMessages(){
    this.msgs = [];
    this.msgs.push({severity: 'success', summary: 'Sucesso', detail: `Olá, ${this.nome}`});
  }

  private onChangeEvent({ target }) {
    this.nome = target.value;
  }
}
