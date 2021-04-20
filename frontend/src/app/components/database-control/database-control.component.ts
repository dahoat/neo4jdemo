import {Component, Input, OnInit} from '@angular/core';
import {DatabaseService} from '../../services/database.service';

@Component({
  selector: 'app-database-control',
  templateUrl: './database-control.component.html',
  styleUrls: ['./database-control.component.css']
})
export class DatabaseControlComponent implements OnInit {
  clearDatabaseMessage: string = null;
  loadPokemonMessage: string = null;
  loadSinnohMapMessage: string = null;
  transactionInProgress = false;

  @Input()
  button: string = null;

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
