import {Component, Input} from '@angular/core';
import {MatButton} from '@angular/material/button';
import {NgIf} from '@angular/common';
import {DatabaseService} from '../../shared/database.service';

@Component({
  selector: 'app-database-control',
    imports: [
        MatButton,
        NgIf
    ],
  templateUrl: './database-control.component.html',
  styleUrl: './database-control.component.scss'
})
export class DatabaseControlComponent {
  clearDatabaseMessage: string|null = null;
  loadPokemonMessage: string|null = null;
  loadSinnohMapMessage: string|null = null;
  transactionInProgress = false;

  @Input()
  button: string|null = null;

  constructor(private databaseService: DatabaseService) {
  }

  ngOnInit(): void {
  }

  loadPokemon(): void {
    this.transactionInProgress = true;
    this.loadPokemonMessage = 'Running...';
    this.databaseService.loadPokemon().subscribe(res => {
        this.loadPokemonMessage = res.result;
        this.transactionInProgress = false;
      },
      error => {
        this.loadPokemonMessage = null;
        this.transactionInProgress = false;
        console.error(error);
        alert('An error occured, see the console.');
      });
  }

  loadSinnohMap(): void {
    this.transactionInProgress = true;
    this.loadSinnohMapMessage = 'Running...';
    this.databaseService.loadSinnohMap().subscribe(res => {
        this.loadSinnohMapMessage = res.result;
        this.transactionInProgress = false;
      },
      error => {
        this.loadSinnohMapMessage = null;
        this.transactionInProgress = false;
        console.error(error);
        alert('An error occured, see the console.');
      });
  }

  clearDatabase(): void {
    this.transactionInProgress = true;
    this.clearDatabaseMessage = 'Running...';
    this.loadPokemonMessage = null;
    this.loadSinnohMapMessage = null;
    this.databaseService.clearDatabase().subscribe(res => {
        this.clearDatabaseMessage = res.result;
        this.transactionInProgress = false;
      },
      error => {
        this.clearDatabaseMessage = null;
        this.transactionInProgress = false;
        console.error(error);
        alert('An error occured, see the console.');
      });
  }
}
