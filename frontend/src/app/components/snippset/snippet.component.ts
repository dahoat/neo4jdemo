import {Component, ElementRef, Input, OnInit, Renderer2} from '@angular/core';


@Component({
  selector: 'app-snippset',
  templateUrl: './snippet.component.html',
  styleUrls: ['./snippet.component.css']
})
export class SnippetComponent implements OnInit {

  @Input()
  query: string;

  copy_ = true;

  constructor() {
  }

  ngOnInit(): void {
  }

  @Input()
  set copy(value: string) {
    if (value === 'false') {
      this.copy_ = false;
    } else {
      this.copy_ = true;
    }
  }

}
