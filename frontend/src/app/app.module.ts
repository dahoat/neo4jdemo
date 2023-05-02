import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatExpansionModule} from '@angular/material/expansion';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatDividerModule} from '@angular/material/divider';
import { BrowserComponent } from './components/browser/browser.component';
import { DatabaseControlComponent } from './components/database-control/database-control.component';
import {HttpClientModule} from '@angular/common/http';
import { SnippetComponent } from './components/snippset/snippet.component';
import {HIGHLIGHT_OPTIONS, HighlightModule} from 'ngx-highlightjs';
import {ClipboardModule} from '@angular/cdk/clipboard';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    BrowserComponent,
    DatabaseControlComponent,
    SnippetComponent
  ],
  imports: [
    BrowserModule,
    MatToolbarModule,
    MatExpansionModule,
    BrowserAnimationsModule,
    MatDividerModule,
    MatButtonModule,
    HttpClientModule,
    HighlightModule,
    ClipboardModule
  ],
  providers: [{
    provide: HIGHLIGHT_OPTIONS,
    useValue: {
      coreLibraryLoader: () => import('highlight.js/lib/core'),
      languages: {
        cypher: () => import('../assets/cypher.js'),
      }
    }
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
