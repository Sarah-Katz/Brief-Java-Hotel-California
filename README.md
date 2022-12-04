# Hotel California - brief Simplon java EE

Brief réalisée dans le cadre de ma formation en spécialisation Java EE chez Simplon.co
Le programme devait être capable de gérer les réservations d'un hotel, et en bonus des imports et exports en .csv.


## Authors

- [@Sarah Katz](https://github.com/Sarah-Katz)

### Usage

Afin d'importer un fichier, il faut impérativement fournir un .csv se nommant "Liste_des_chambres.csv" à la racine du programme.
Le formatage de ce fichier utilise des virgules (",") comme séparateur pour les champs suivants et dans l'ordre :
"Numéro de chambre,Catégorie,Capacité,Prix,Disponible".

En cas de non-respect du formatage, le programme créera la liste avec "0" comme numéro de chambre, de catégorie, comme capacité et comme prix si ces champs contiennent des valeurs autres que des chiffres entier.
Si la valeur "Disponible" est autre que 'true' ou 'false', elle seras par défaut définie sur fausse.

L'export de la liste via le programme créé ou écrase "Liste_des _chambres.csv" à la racine.

La réservation des chambres vient prendre en compte leur disponibilité et la mettre à jour dans le .csv.