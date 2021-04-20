CREATE
  (snowpoint_city:City{name:"Snowpoint City"}),
  (eterna_city:City{name:"Eterna City"}),
  (celestic_city:City{name:"Celestic City"}),
  (floaroma_city:City{name:"Floaroma City"}),
  (veilstone_city:City{name:"Veilstone City"}),
  (solaceon_city:City{name:"Solaceon City"}),
  (hearthome_city:City{name:"Hearthome City"}),
  (canalave_city:City{name:"Canalave City"}),
  (jubilife_city:City{name:"Jubilife City"}),
  (oreburgh_city:City{name:"Oreburgh City"}),
  (sunyshore_city:City{name:"Sunyshore City"}),
  (pastoria_city:City{name:"Pastoria City"}),
  (sand_gem_town:Town{name:"Sand Gem Town"}),
  (twinleaf_town:Town{name:"TwinLeaf Town"}),
  (lake_acuity:Lake{name:"Lake Acuity"}),
  (lake_varity:Lake{name:"Lake Varity"}),
  (lake_valor:Lake{name:"Lake Valor"}),

  (canalave_city)-[:ROUTE{number: 218}]->(jubilife_city),
  (jubilife_city)-[:ROUTE{number: 205}]->(floaroma_city),
  (jubilife_city)-[:ROUTE{number: 203}]->(oreburgh_city),
  (jubilife_city)-[:ROUTE{number: 202}]->(sand_gem_town),
  (sand_gem_town)-[:ROUTE{number: 201}]->(lake_varity),
  (sand_gem_town)-[:ROUTE{number: 201}]->(twinleaf_town),
  (oreburgh_city)-[:ROUTE{number: 206}]->(eterna_city),
  (oreburgh_city)-[:ROUTE{number: 208}]->(hearthome_city),
  (eterna_city)-[:ROUTE{number: 211}]->(celestic_city),
  (eterna_city)-[:ROUTE{number: 216}]->(lake_acuity),
  (eterna_city)-[:ROUTE{number: 216}]->(snowpoint_city),
  (celestic_city)-[:ROUTE{number: 210}]->(solaceon_city),
  (celestic_city)-[:ROUTE{number: 215}]->(veilstone_city),
  (solaceon_city)-[:ROUTE{number: 209}]->(hearthome_city),
  (hearthome_city)-[:ROUTE{number: 212}]->(pastoria_city),
  (pastoria_city)-[:ROUTE{number: 213}]->(lake_valor),
  (lake_valor)-[:ROUTE{number: 222}]->(sunyshore_city),
  (lake_valor)-[:ROUTE{number: 214}]->(veilstone_city),

  (snowpoint_city)-[:ROUTE{number: 217}]->(hearthome_city)



//match p=(start:CITY{name:"Snowpoint City"})-[:ROUTE*]-(end:CITY{name:"Hearthome City"}) return p
//match p=(start:CITY{name:"Snowpoint City"})-[:ROUTE*]->(end:CITY{name:"Hearthome City"}) return p
//match p=shortestPath((start:CITY{name:"Snowpoint City"})-[:ROUTE*]-(end:CITY{name:"Hearthome City"})) return p
//match p=shortestPath((start:CITY{name:"Snowpoint City"})-[:ROUTE*..10]-(end:CITY{name:"Hearthome City"})) return p
