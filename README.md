# Oraxen-Screwdriver-Mechanic

- A simple rotate system for furniture, just give an item a "screwdriver" mechanic and if you right-click on furniture, you will rotate it, and see some information on ActionBar.

<dl>
  <dt> ATTENTION! </dt>
  <dd>You must put in your Oraxen folder on "mechanics.yml" a "screwdriver" section!<br>Like that:  </dd>

```yml
# MISCELLANEOUS

screwdriver: 
  enabled: true

commands:
  enabled: false
...
```
  <dt> Using the mechanic: </dt>

```yml
screwdriver:
  displayname: "Your Item Name"
  material: PAPER
  Pack:
    generate_model: false 
    model: your/model/location
  Mechanics:
    screwdriver:
      rotate: true
```
</dl>
