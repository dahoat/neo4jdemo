import {Component, inject, Input} from '@angular/core';
import {MatButton} from '@angular/material/button';
import {NgIf} from '@angular/common';
import {Highlight, HighlightJS, HighlightLoader} from 'ngx-highlightjs';
import {CdkCopyToClipboard} from '@angular/cdk/clipboard';

@Component({
  selector: 'app-snippet',
  imports: [
    MatButton,
    NgIf,
    Highlight,
    CdkCopyToClipboard
  ],
  templateUrl: './snippet.component.html',
  styleUrl: './snippet.component.scss'
})
export class SnippetComponent {

  @Input()
  query: string|null = null;

  copy_ = true;


  ngOnInit(): void {
  }

  @Input()
  set copy(value: string) {
    this.copy_ = value !== 'false';
  }

}
