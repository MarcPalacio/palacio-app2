
# Inventory Management - How to use

An inventory management application created for Dr. Hollander's Fall 2021 course in
Object Oriented Programming at the University of Central Florida.

## What the Program Can Do
- Store up to 1024 items in one list
  - Items consisting of a name, a price, and a unique serial number
- Add items to the inventory
- Edit items in the inventory
- Search for items in the inventory
- Save and load inventories

## Functions
### Adding Items
In order to add an item to the inventory, the user must have the 3 fields under "Add Item
To Inventory" tab properly filled out, then press the "Add Item" button to the right of those
input fields.
The program will fail to add an item and send a message if:
- The user fails to put a name that is between 2-256 characters (inclusive)
- The user fails to put a valid price
  - Either inputting letters when there should be numbers OR
  - Inputting a value less than 0
- The user fails to put the serial number in the valid format
- The user fails to put a new unique serial number

### Searching For Items
Near the bottom of the screen, the user will see the "Search Item In Inventory" tab. The
search bar within this tab will allow the user to type in whatever they are searching for based off the name or
the serial number of that item. By leaving the search bar blank, all items in the inventory
will be on display.

### Editing Items
If the user wants to edit an item in the inventory, they must select the element in the inventory.
After that, they must go to the "Options" tab at the very bottom of the program and click the
"Edit Item" button. From there, they will be taken to another screen where they will be able to make
edit to the selected item. After making the edits, the user must click the "Edit Item" button to
save the changes and go back to the inventory list. If the user wishes to not make any changes, they
may select the "Cancel Edit" button in order to return to the inventory list. Errors will 
occur properly if the user fails to input the proper format for the fields.

### Deleting One Item
If the user wants to delete an item from the list, they must select the element in the inventory.
After that, they will go to the "Options" tab at the very bottom of the program and click the
"Delete Item" button. This will cause the item that was selected to be removed from the list.
If the user tries to delete an item without select an element, an error will occur.

### Deleting All Items
Similar to Deleting One Item, the user must go to the "Options" tab at the very bottom of the program,
then select the "Delete Inventory" button to delete all items in the inventory.

### Saving Inventory
If the user wants to save the inventory they are currently on, they must go to the "Options" tab
at the very bottom of the program and select "Save Inventory". From here they can choose
to save their file in 2 formats, TSV or HTML. After selecting which format, they can then
give their file a name and save the inventory.

### Loading Inventory
If the user wants to load a previous inventory, they must go to the "Options" tab
at the very bottom of the program and select "Load Inventory". From here they can choose
which file formats to look for, either TSV or HTML and select that file. After selecting that file,
the inventory will update and show those elements on the table. Note, loading an inventory will
clear your current inventory.