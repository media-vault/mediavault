<h1 align="center">LibreUno</h1>
<h3 align="center">A Unified Software Media System</h3>

---

<p align="center">
<img alt="Logo Banner" src="https://raw.githubusercontent.com/media-vault/mediavault-ux/main/libreuno_banner.png?sanitize=true"/>
</p>

---

<strong>Something not working correctly?</strong><br/>
Open an <a href="">Issue</a> on GitHub.<br/>

<strong>Want to contribute?</strong><br/>
Check out our <a href="">contributing guide</a> to see where you can help and our <a href="">community standards</a>.</br>

<strong>New idea or improvement?</strong><br/>
Check out our <a href="">feature request hub</a>.<br/>

# Prerequisites
- Java Development Kit (JDK) 17 or higher
- Maven 3.6 or higher
- Docker and Docker Compose

# Installation

1. Clone the repository:

`git clone https://github.com/libreuno/libreuno.git`

`cd libreuno`

2. To build the project with maven and run it in docker we use the build script

`./build.sh`

3. Access the LibreUno web interface

Open a web browser and naviage to `http://localhost:8080` 

# Server Configuration

To add media follow these steps.

1. Make two directories in the root of the project
   
  `mkdir ./db_data`
  `mkdir ./media_data`
  
2. Add media to the media_data directory
3. Add your media via the ui from the server client and make sure the file path matches 
