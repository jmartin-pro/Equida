let ajouterCourseButton = document.querySelector("#ajouterCourse");
let idCourseInput = document.querySelector("#idCourse");
let classementCourseInput = document.querySelector("#classementCourse");
let listeCourses = document.querySelector("#listeCourses");

for(let i = 0 ; i < listeCourses.children.length ; i++) {
	listeCourses.children[i].addEventListener("click", supprimerCourse);
}

ajouterCourseButton.addEventListener("click", ajouterCourse);

function ajouterCourse(event) {
	event.preventDefault();
	
	if(parseInt(idCourseInput.value) != idCourseInput.value || idCourseInput.value.length == 0)
		return;
	
	let node = document.createElement("a");
	node.href = "#";
	node.className = "collection-item";
	node.addEventListener("click", supprimerCourse);
	
	let badgeNode = document.createElement("span");
	badgeNode.className="badge";
	badgeNode.appendChild(document.createTextNode("X"));
	
	let inputIdCourseNode = document.createElement("input");
	inputIdCourseNode.name="idCourse[]";
	inputIdCourseNode.type="hidden";
	inputIdCourseNode.value=idCourseInput.value;
	
	let inputClassementCourseNode = document.createElement("input");
	inputClassementCourseNode.name="classement[]";
	inputClassementCourseNode.type="hidden";
	inputClassementCourseNode.value=classementCourseInput.value;
	
	node.appendChild(inputIdCourseNode);
	node.appendChild(inputClassementCourseNode);
	node.appendChild(badgeNode);
	node.appendChild(document.createTextNode(idCourseInput.options[idCourseInput.selectedIndex].text + " " + " - \nPosition : " + classementCourseInput.value));
	
	listeCourses.appendChild(node);  
	
	idCourseInput.value = 0;
	classementCourseInput.value = "";
}

function supprimerCourse(event) {
	event.preventDefault();
	event.currentTarget.parentNode.removeChild(event.currentTarget);
}