var list = [];

function addEntry(entry){
	var dlzka = list.length;
	list[dlzka] = entry;
	renderOneList(entry);
}

function renderList() {
	var element = document.getElementById('todo-list');
	var lenght1 = list.length;
	for(var i = 0;i<lenght1;i++) {
		// alert(lenght1);
		// alert(list);
		// alert(i);
		var childElement = document.createElement('li');
		childElement.textContent = list[i];
		element.appendChild(childElement);	
	}
}

function renderOneList(item) {
	var element = document.getElementById('todo-list');
	var lenght1 = list.length;
	var childElement = document.createElement('li');
	childElement.textContent = item;
	childElement.addEventListener("click",clickListElement);
	element.appendChild(childElement);	
	
}

function clickListElement(element){
	var element1 =  element.target;
	element1.setAttribute("style","color:red");
	element1.setAttribute("id","zaciarknuty");
	

}

function deleteItems(){
	var parent = document.getElementById("todo-list");
	var c = document.getElementById("zaciarknuty");
		parent.removeChild(c);
	
}

function addFormContain(){
	var formContain = document.getElementById("new-entry").firstname.value;
	addEntry(formContain);
}
