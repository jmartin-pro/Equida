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
	inputIdCourseNode.name="idCourse["+listeCourses.children.length+"]";
	inputIdCourseNode.type="hidden";
	inputIdCourseNode.value=idCourseInput.value;
	
	let inputClassementCourseNode = document.createElement("input");
	inputClassementCourseNode.name="classement["+listeCourses.children.length+"]";
	inputClassementCourseNode.type="hidden";
	inputClassementCourseNode.value=classementCourseInput.value;
	
	node.appendChild(inputIdCourseNode);
	node.appendChild(inputClassementCourseNode);
	node.appendChild(badgeNode);
	node.appendChild(document.createTextNode(idCourseInput.options[idCourseInput.selectedIndex].text + " " + " - \nPosition : " + classementCourseInput.value));
	
	listeCourses.appendChild(node);  
	
	classementCourseInput.value = "";
}

function supprimerCourse(event) {
	event.preventDefault();
	
	let deleteCourse = event.currentTarget.children[0].name;
	let index = parseInt(deleteCourse.slice(deleteCourse.indexOf("[")+1, deleteCourse.indexOf("]")));
	
	event.currentTarget.parentNode.removeChild(event.currentTarget);
	
	for(let i = index; i<listeCourses.children.length; i++){
		listeCourses.children[i].children[0].name = "idCourse[" + index + "]";
		listeCourses.children[i].children[1].name = "classement[" + index + "]"
		index++;
	}
	
}