import { Component } from '@angular/core';
import {MatDivider} from '@angular/material/divider';
import {MatExpansionPanel, MatExpansionPanelHeader, MatExpansionPanelTitle} from '@angular/material/expansion';
import {MatToolbar} from '@angular/material/toolbar';
import {SnippetComponent} from './component/snippet/snippet.component';
import {DatabaseControlComponent} from './component/database-control/database-control.component';
import {BrowserComponent} from './component/browser/browser.component';

@Component({
  selector: 'app-root',
  imports: [MatDivider, MatExpansionPanel, MatExpansionPanelHeader, MatExpansionPanelTitle, MatToolbar, SnippetComponent, DatabaseControlComponent, BrowserComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'asdf';
}
