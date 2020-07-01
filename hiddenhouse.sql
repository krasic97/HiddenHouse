-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hiddenhouse
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `action_alias`
--

DROP TABLE IF EXISTS `action_alias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action_alias` (
  `id` int(11) NOT NULL,
  `alias` varchar(30) DEFAULT NULL,
  `id_action` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_action` (`id_action`),
  CONSTRAINT `action_alias_ibfk_1` FOREIGN KEY (`id_action`) REFERENCES `commands` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action_alias`
--

LOCK TABLES `action_alias` WRITE;
/*!40000 ALTER TABLE `action_alias` DISABLE KEYS */;
INSERT INTO `action_alias` VALUES (1,'fine',1),(2,'ucciditi',1),(3,'suicidati',1),(4,'muori',1),(5,'chiudi',8),(6,'inventario',2),(7,'zaino',2),(8,'nord',3),(9,'n',3),(10,'sud',4),(11,'s',4),(12,'est',5),(13,'e',5),(14,'ovest',6),(15,'o',6),(16,'apri',7),(17,'spalanca',7),(18,'scavicchia',7),(19,'spingi',9),(20,'premi',9),(21,'pigia',9),(22,'vai',11),(23,'muoviti',11),(24,'procedi',11),(25,'prendi',12),(26,'raccogli',12),(27,'parla',13),(28,'versa',14),(29,'usa',15),(30,'adopera',15),(31,'utilizza',15),(32,'osserva',16),(33,'guarda',16),(34,'scruta',16),(35,'accendi',17),(36,'attiva',17),(37,'spegni',18),(38,'disattiva',18),(39,'taglia',22),(40,'recidi',22),(41,'inserisci',23),(42,'gira',24),(43,'aziona',24),(44,'sali',25);
/*!40000 ALTER TABLE `action_alias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alias_object`
--

DROP TABLE IF EXISTS `alias_object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alias_object` (
  `id` int(11) NOT NULL,
  `alias_name` varchar(50) DEFAULT NULL,
  `id_object` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alias_object`
--

LOCK TABLES `alias_object` WRITE;
/*!40000 ALTER TABLE `alias_object` DISABLE KEYS */;
INSERT INTO `alias_object` VALUES (1,'cristallo arancione',1),(2,'cassapanca',2),(3,'radio',3),(4,'radio modificata',3),(5,'altare',4),(6,'maniglia riflettente',22),(7,'maniglia forma diamante',5),(8,'ingrnaggio EST',6),(9,'ingranaggio OVEST',7),(10,'coltello',8),(11,'coltello affilato',8),(12,'gamba tavolo',9),(13,'pulsante',10),(14,'bottone muro',10),(15,'cassetto',11),(16,'cassetto credenza',11),(17,'boccetta luminescente',12),(18,'boccetta',12),(19,'boccetta liquido luminescente',12),(20,'maniglia diamante',5),(21,'boccetta liquido',12),(22,'chiave',13),(23,'cristallo verde',14),(24,'specchio',15),(25,'armadio',16),(26,'orecchino',17),(27,'orecchino occhi serpente',17),(28,'spada',18),(29,'spada affilata',18),(30,'edera',19),(32,'affresco',20),(33,'grande affresco',20),(34,'lancia',21),(35,'tavolo pietra',24),(31,'stella',23),(36,'stella venti',23),(37,'tavolo pietra',24),(38,'sedie',25),(39,'sedie rotte',25),(40,'finestra',26),(41,'finestra cava',26),(42,'letto',27),(43,'pensile',28),(44,'tavoli rotti',29),(45,'tavolo rotto',29),(46,'credenza',30),(47,'armature',31),(48,'moschetti',32),(49,'armi',32),(50,'ariete',33),(51,'ariete medioevale',33),(52,'corda',34),(53,'corde',34),(54,'scala',35),(55,'porta',37),(56,'maniglia',5);
/*!40000 ALTER TABLE `alias_object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commands`
--

DROP TABLE IF EXISTS `commands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commands` (
  `id` int(11) NOT NULL,
  `action` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commands`
--

LOCK TABLES `commands` WRITE;
/*!40000 ALTER TABLE `commands` DISABLE KEYS */;
INSERT INTO `commands` VALUES (1,'END'),(2,'INVENTORY'),(3,'NORTH'),(4,'SOUTH'),(5,'EAST'),(6,'WEST'),(7,'OPEN'),(8,'CLOSE'),(9,'PUSH'),(10,'PULL'),(11,'WALK'),(12,'PICK_UP'),(13,'TALK'),(14,'POUR'),(15,'USE'),(16,'LOOK'),(17,'TURN_ON'),(18,'TURN_OFF'),(19,'BACK'),(20,'SAVE'),(21,'LOAD'),(22,'CUT'),(23,'INSERT'),(24,'ACTUATE'),(25,'CLIMB');
/*!40000 ALTER TABLE `commands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `description`
--

DROP TABLE IF EXISTS `description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `description` (
  `id` int(11) NOT NULL,
  `descr` varchar(8000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `description`
--

LOCK TABLES `description` WRITE;
/*!40000 ALTER TABLE `description` DISABLE KEYS */;
INSERT INTO `description` VALUES (1,'Spinto dalla tua irrefrenabile curiosità e dal tuo grande intuito investigativo,\ntieni bene a mente le parole di un tuo vecchio antenato venutoti in sogno.\nRicordi molto bene la presenza di una vecchia cava di bauxite nella tua città,\ned è per questo che zaino in spalla ti cimenti in questa grande avventura.\nGiunto alla cava ormai piena di acqua ti addentri subito all\'interno della vegetazione\ned è qui che trovi l\'incredibile e leggendaria porta della Casa Nascosta.\nDa grande incosciente percorri la vecchia e ormai rotta scalinata, in fondo vedi la luce.'),(2,'Una pesante ghigliottina chiude la scalinata alle tue spalle. Sei in trappola!'),(3,'La stanza è piena di ragnatele ma in corrispondenza del raggio di luce che vedi per terra c\'è una grande stella dei venti.\nSembra essere lì da migliaia di anni.\nIn corrispondenza di ogni punto cardinale vi è una porta eccetto del punto cardinale SUD che porta alla scalinata che hai già percorso e del punto cardinale NORD.\nLa porta a EST è socchiusa e sembra essere l\'unica accessibile.\nLa porta a OVEST è bloccata da una pesante trave di legno.'),(4,'La porta a EST è socchiusa e sembra essere l\'unica accessibile.'),(5,'La porta a OVEST è bloccata da una pesante trave di legno. Da qui non puoi passare...'),(6,'E\' una stella dei venti fatta interamente in marmo bianco,\npresente però delle punte fatte in qualche altro materiale di colore rosso porpora.\nRiesci a leggere bene i punti cardinali.\nMemorizzali, potranno esserti utili!'),(7,'Sei in una stanza a forma di ottagono, al centro della stanza vi è un grande tavolo in pietra, un mucchio di sedie ormai inutilizzabili e una grande cassapanca. Vi è anche una porta ma l\'architrave di quest\'ultima ha ceduto murando completamente il passaggio a EST.'),(8,'E\' un tavolo in pietra comune, molto pesante ma di ottima fattura.'),(9,'Sono sedie ormai inutilizzabili, distrutte dal tempo e dai tarli.'),(10,'E\' una grande cassapanca in legno massello molto pregiato, il meccanisco di apertura sembra ancora funzionante. Non resta che aprirla.'),(11,'Con qualche difficoltà vista la ruggine presente sulle cerniere, riesci ad aprire la cassapanca. Dinnanzi a te si presenta un cristallo arancione luccicante e un passaggio segreto a SUD della stanza.'),(12,'Il passaggio segreto all\'interno della cassapanca ti ha portato in una stanza segreta. In un angolo della stanza puoi vedere una vecchia radio. '),(13,'A EST vi è una porta chiusa da una serratura misteriosa, a NORD hai l\'entrata attraverso la cassapanca, ad SUD e ad OVEST non c\'è nulla.'),(14,'E\' una vecchia radio segnata dal tempo, non riesci a vedere se ci sono le batterie all\'interno ma noti una piccola apertura sul retro. Probabilmente è una radio modificata. L\'apertura è abbastanza grande da poter inserire un cristallo.'),(15,'Appena inserisci il cristallo all\'interno della radio, quest\'ultimo inizia a emanare luce. La radio si attiva, deve essere una radio particoalre che da voce ai cristalli... \'la luce che resta è tutto ciò che conta...crrr..crrrr... segui la tua salvezza!\'. La piccola porta davanti a te si apre misteriosamente...'),(16,'La stanza presenta un grande altare di marmo probabilmente era un luogo sacro. Vi è anche una grande finestra che si affaccia sulla cava e una porta a EST ma senza maniglia. '),(17,'L\'altare presenta un\'apertura nella parte inferiore all\'interno vi è una maniglia a forma di diamante'),(18,'Dalla finestra puoi scorgere bene il panorama che ti offre la vecchia cava, un rosso tramonto ti accarezza la faccia... Ma alla fine tu non ne capisci niente di romanticismo. Sarebbe meglio continuare.'),(19,'Sembra essere la stanza del prete, vi è un letto ormai distrutto dal tempo e dall\'usura. Un paio di topi banchetta con quel che resta della carcassa di un pipistrello. Che scena orribile! Vi è una porta a NORD.'),(20,'Nella credenza non sembra esserci nulla di interessante, è piena di calici rotti e una tovaglia bucata'),(21,'Sei all\'interno di una stanza ellittica, il tetto della stanza è crollato. Sul muro ad EST vi è un grande ingranggio. In maniera speculare puoi vedere lo stesso ingranaggio sul muro a OVEST. \n'),(22,'L\'ingranaggio può solo ruotare in senso orario'),(23,'Ruotando l\'ingranggio[EST] senti tremare la stanza ( e ti tremano anche le gambe)... si è aperto per metà un cunicolo a OVEST. Purtroppo il maccanismo non regge e appena lasci la ruota dentata il cunicolo si chiude'),(24,'Rutando l\'ingranaggio [OVEST]senti tremare la stanza ( e ti tremano anche le gambe)... si è aperto un cunicolo a EST. Il meccanismo sembra reggere forse puoi passare.'),(25,'L\'ingranaggio è identico a quello che vedi dall\'altra parte della stanza, non riesci a vedere che tipo di meccanismo governa.'),(26,'Ti trovi in una vecchia cucina, puoi vedere del vecchio pentolame color rame appeso ai muri. Un pensile semiaperto ed dei tavoli rotti. I tavoli non hanno più le gambe stranamente. A SUD vi è una porta chiusa da uno strano meccanismo sul muro. Un bottone all\'interno di un incavo molto stretto. L\'incavo è troppo stretto e lungo per inserire la tua mano.'),(27,'Puoi notare un vecchio pensile datato e semiaperto, forse c\'è qualcosa all\'interno.'),(28,'Il bottone è posto in profondità nell\'incavo, la tua mano è troppo corta e grande per premerlo.'),(29,'La gamba del tavolo è tonda e stretta abbastanza da entrare nell\'incavo e spingere il bottore, uno strano meccanismo sblocca la porta. Non ti resta che aprirla'),(30,'Dinnanzi a te si presenta una stanza crollata per metà, dal muro rotto vedi bene il tramonto sulla cava. La stanza è ricoperta di edere e altre erbacce, per fortuna il pavimento è intatto ma la vegetazione ostacola il passaggio. Ad EST dietro la vegetazione vedi una porta di colore rosso porpora.'),(31,'Un\' edera molto fitta ma fortunatamente non troppo spessa, forse si può tagliare.'),(32,'Non con poche difficoltà riesci a tagliare i vari rami dell\'edera che ostacolavano il passaggio. Ora la porta è libera.'),(33,'Sei entrato in una sala da pranzo al centro vi è un vecchio e grande tavolo in legno, delle alte sedie e una credenza con due ampie ante e un cassetto. La credenza è a NORD della stanza.'),(34,'Una credenza molto datata e segnata dal tempo e dall\'umidità. Le ante della credenza sono chiuse a chiave, tranne il cassetto. Dalle ante però arriva uno spiffero d\'aria.'),(35,'Nel  cassetto  è presente una chiave e una boccetta con uno strano liquido luminescente'),(36,'Aprendo le ante della credenza, è apparso un cunicolo stretto. Esattamente a NORD della stanza.'),(37,'Che strano... il cunicolo è collegato ad una grande cassapanca...'),(38,'La stanza ha una forma ottagonale, al centro vi è un grande tavolo in pietra, delle sedie ormai inutilizzabili e una porta con un architrave crollato. La stanza sembra essere gemella dell\'altra in cui sei passato poco fa! Con una sola differenza, qui vi è una porta a NORD oltre quella murata.'),(39,'Inserito il cristallo nella radio senti questo terrificante messaggio: \'Due gemelli non possono essere separati...crrr..crrr...Perdono! Perdono !....crr... Bisogna pagare il sacrificio col sangue !\'. Non promette niente di buono!'),(40,'La porta non si apre...'),(41,'Inizi ad avvertire un enorme peso su di te, qualcosa di tenebroso e occulto avvolge la stanza... improvisamente ti senti afferrare la mano... Hai paura (che novità d\'altronde...). Non vi è più luce nella stanza ma la radio inizia a parlare senza cristalli ! \'Crrr...crr.....Mayu sei tu ? Dove sei Mayu? Non ti vedo !....crrrr..crrr...Non lasciarmi ti pregoooo\'. Uno spirito ti ha bloccato e sta cercando di trascinarti. Devi fare qualcosa o farai la stessa fine dello spirito!'),(42,'Il coltello non ha nessun effetto con lo spirito... la tua forza sta diminuendo velcemente. Devi assolutamente fare qualcosa!'),(43,'Lo spirito inizia lentamente a lasciarti andare fin quando non sparisce in una esplosione di colori brillanti, la porta dinnanzi a te finalmente si apre.'),(44,'Davanti ai tuoi occhi si presenta un grande soggiorno con ampie vetrate e tende ormai sbiadite dalla polvere. Ad OVEST vi è una porta con un grande arco. In un angolo uno specchio girevole che riflette la luce del sole sul muro a OVEST dove è presente la porta.'),(45,'La porta è chiusa da un meccanismo particolare, sulla maniglia vi è una specie di riflettore.'),(46,'Girando lo specchio verso il riflettore la porta si sblocca. Ora puoi aprirla'),(47,'Sei in una lunga stanza con dei lucernari rotti, sui muri puoi vedere una moltitudine di dipinti tra i quali spiccano un grande affresco e un vecchio armadio. Ad OVEST puoi vedere una porta con uno stemma di un serpente che si morde la coda. '),(48,'La porta non si apre è chiusa con qualche meccanismo sofisticato.'),(49,'L\'affresco raffigura un serpente che si morde la coda, stranamente però al serpente manca un occhio e osservando bene all\'interno dell\'altro occhio riesci a scorgere la stanza con la stella dei venti.'),(50,'Nell\'armadio tra tanti vestiti inutilizzabili, puoi vedere un orecchino a forma di occhio di serpente che luccica.'),(51,'Dopo aver inserito l\'orecchino a forma di occhio di serpende nella cavità oculare del serpente dipinto sul muro si odono dei rumori meccanici simili a ingranaggi che girano. Sembrano provenire dalla stanza della stella dei venti. La porta ad OVEST con lo stemma del serpente sembra essersi sbloccata.'),(52,'Osservando la stanza attraverso l\'occhio ambrato del serpente dipinto puoi notare che la stella dei venti è quasi completamente illuminata eccezion fatta per la punta ad OVEST.'),(53,'Entrando in questa stanza si notano delle grandi armature disposte sulla destra e sulla sinistra della stanza creando un corridoio centrale che permette di ammirarle. Le armature sono dotate in maniera alternata di una spada o di una lancia. A SUD della stanza vi è una porta.'),(54,'Sembrano armature medioevali ancora perfettamente lucide, sono molto pesanti e di gran lunga più alte di te... inizia a desistere, non puoi indossarle.'),(55,' Sei in una stanza adibita allo stoccaggio delle armi, in alto sui muri puoi vedere degli antichi moschetti. Probabilmente sono lì da centinaia di anni. Sul soffitto noti un ariete medioevale. L\'ariete è direzionato verso una porta ad EST bloccata da una grande trave in legno, inoltre l\'ariete stesso è ancorato al soffitto con delle corde.'),(56,'Le armi sono posizionate troppo in alto, non puoi raggiungerle.'),(57,'Non puoi utilizzare la spada per tagliare le corde perchè sono troppo in alto e tu sei troppo basso.'),(58,'Con molta fatica vista la tua statura riesci a tagliare le corde che ancoravano l\'ariete che si scontra con la porta, sfondandola e provocando un assordante rumore. Ora la via è libera.'),(59,'Sei di nuovo nella stanza con la stella dei venti, quest\'ultima ha tutte le punte illuminate e dal soffitto è calata una scala.'),(60,'Riesci finalmente ad uscire all\'aria aperta e il sole sta quasi per tramontare. Improvvisamente ti ricordi di avere un accendino in tasca e pensi a quanto sei stato stupido. Scegli di usare la notte a tuo vantaggio e con l\'aiuto dell\'accendino dai fuoco ad una serie di assi di legno creando un segnale luminoso. Sei fortunato, per una qualche congiunzione astrale passa un elicottero che ti porta in salvo. Come diceva una nota pubblicità: \'Sembrava impossibile...Ma ce l\'ho fatta!\'. FINE.'),(61,'Un cunicolo molto stretto e con molte ragnatele. Spero tu non sia aracnofobico...'),(62,'La porta a SUD è chiusa da una serratura misteriosa, devi trovare il modo per aprirla'),(63,'Non puoi aprire la porta senza maniglia!'),(64,'Sembra esserci una botola a EST, ma è chiusa quasi ermeticamente.'),(65,'Devo ammettere che sei fortunato...procediamo!'),(66,'Devi trovare il modo di sbloccare questo passaggio prima di procedere nella prossima stanza'),(67,'Dinnanzi a te è apparso un cunicolo stretto, in fondo vedi luce. Che strano... il cunicolo è collegato ad una grande cassapanca...'),(68,'Sembra essere un cristallo di aragonite arancione, ha la grandezza di una prugna circa.'),(69,'Nella stanza non vi è niente di interessante, ma in un angolo c\'è un cristallo verde'),(70,'Una particolare maniglia a forma di diamante probabilmente vale anche un mucchio di danari, ma non siamo qui per soldi...a dirla tutta non so neanche perchè mi trovo con te.'),(71,'E\' un coltello di ottima fattura, un po\' arruginito ma molto tagliente'),(72,'Sembra una vecchia ampolla contente qualche liquido medicinale, è di colore bluastro'),(73,'Una vecchia chiave di bronzo.'),(74,'E\' un cristallo di fluorite, di un bel verde e leggermente luminoso'),(75,'L\'antico specchio girevole riflette la luce del sole sul muro ad est, forse si può regolare il raggio...'),(76,'L\'orecchino ha la forma caratteristica di un occhio di serpente, è di color ambra.'),(77,'E\' una rarissima spada medioevale, molto affilata'),(78,'Una lancia stile romano, un po\' rovinata ma funzionale'),(79,'La porta era chiusa evidentemente da molto tempo, con qualche difficoltà però riesci a sbloccarla.'),(80,'Una scala di corda con gradini in legno, porta fuori dalla casa.'),(81,'E\' un letto di paglia, le lenzuola sono tutte strappate e bucate. E\' ovviamente inutilizzabile.'),(82,'Tavoli ormai inutilizzabili e tutti senza gambe... che strano!'),(83,'Una maniglia molto particolare, non l\'hai mai vista prima. Presenta una specie di riflettore, forse puntando la luce dello specchio si sblocca.'),(84,'E\' un vecchio armadio stile 1800, molto pesante e consumato dal tempo.'),(85,'Un comunissimo ariete medioevale, legato con delle corde al soffitto. Sembra molto pesante ed è direzionato verso la porta.'),(86,'Delle corde non troppo spesse, forse si possono tagliare'),(87,'Questa stanza non contiene oggetti.'),(88,'Uno spaventoso fantasma di una ragazza vestita con un kimono sporco\ndi sangue (da queste parti non si vedono ragazze col kimono ma fantasmi\nche cosa curiosa...).\n Ah...ha la testa mozzata anche...'),(89,'E\' una comunissima porta, la maniglia è assente');
/*!40000 ALTER TABLE `description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doors`
--

DROP TABLE IF EXISTS `doors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doors` (
  `id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `pre_room` int(11) NOT NULL,
  `next_room` int(11) NOT NULL,
  `is_locked` tinyint(1) DEFAULT NULL,
  `descr` int(11) DEFAULT NULL,
  `lock_descr` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doors`
--

LOCK TABLES `doors` WRITE;
/*!40000 ALTER TABLE `doors` DISABLE KEYS */;
INSERT INTO `doors` VALUES (1,'est_stella_venti',1,2,0,4,NULL),(2,'ovest_stella_venti',1,14,1,NULL,5),(3,'sud_stanza_ottagono',2,3,1,61,66),(4,'ovest_stanza_ottagono',2,1,0,NULL,NULL),(5,'nord_stanza_segreta',3,2,0,NULL,NULL),(6,'sud_stanza_segreta',3,4,1,NULL,62),(7,'nord_stanza_altare',4,3,0,NULL,NULL),(8,'est_stanza_altare',4,5,1,NULL,63),(9,'ovest_stanza_prete',5,4,0,NULL,NULL),(10,'nord_stanza_prete',5,6,0,NULL,NULL),(11,'sud_stanza_ellittica',6,5,0,NULL,NULL),(12,'est_stanza_ellittica',6,7,1,65,64),(13,'ovest_vecchia_cucina',7,6,0,NULL,NULL),(14,'sud_vecchia_cucina',7,8,1,NULL,66),(15,'nord_stanza_vegetazione',8,7,0,NULL,NULL),(16,'ovest_stanza_vegetazione',8,9,1,NULL,66),(17,'est_stanza_pranzo',9,8,0,NULL,NULL),(18,'nord_stanza_pranzo',9,10,1,67,66),(19,'sud_stanza_fantasma',10,9,0,NULL,NULL),(20,'nord_stanza_fantasma',10,11,1,NULL,66),(21,'sud_grande_soggiorno',11,10,0,NULL,NULL),(22,'ovest_grande_soggiorno',11,12,1,NULL,45),(23,'est_stanza_affresco',12,11,0,NULL,NULL),(24,'ovest_stanza_affresco',12,13,1,NULL,48),(25,'est_stanza_armature',13,12,0,NULL,NULL),(26,'sud_stanza_armature',13,14,0,NULL,NULL),(27,'nord_stanza_armi',14,13,0,NULL,NULL),(28,'est_stanza_armi',14,1,1,59,66),(29,'sud_stella_venti',1,1,1,NULL,2);
/*!40000 ALTER TABLE `doors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_logic`
--

DROP TABLE IF EXISTS `game_logic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_logic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action` varchar(20) DEFAULT NULL,
  `object_1` varchar(20) DEFAULT NULL,
  `object_2` varchar(20) DEFAULT NULL,
  `descr` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_logic`
--

LOCK TABLES `game_logic` WRITE;
/*!40000 ALTER TABLE `game_logic` DISABLE KEYS */;
INSERT INTO `game_logic` VALUES (1,'EAST',NULL,NULL,NULL),(2,'OPEN','SETTLE',NULL,11),(3,'PICK_UP','ORANGE_CRYSTAL',NULL,NULL),(4,'PICK_UP','RADIO',NULL,NULL),(5,'USE','ORANGE_CRYSTAL','RADIO',15),(6,'NORTH',NULL,NULL,NULL),(7,'LOOK','ALTAR',NULL,NULL),(8,'PICK_UP','HANDLE',NULL,NULL),(9,'USE','HANDLE','DOOR',79),(10,'NORTH',NULL,NULL,NULL),(11,'ACTUATE','WEST_GEAR',NULL,24),(12,'WEST',NULL,NULL,NULL),(13,'PUSH','TABLE_LEG','BUTTON',29),(14,'CUT','IVY','KNIFE',32),(15,'EAST',NULL,NULL,NULL),(16,'OPEN','DRAWER',NULL,NULL),(17,'USE','KEY','CUPBOARD',36),(18,'NORTH',NULL,NULL,NULL),(19,'PICK_UP','GREEN_CRYSTAL',NULL,NULL),(20,'USE','GREEN_CRYSTAL','RADIO',39),(21,'NORTH',NULL,NULL,41),(22,'POUR','JAR','GHOST',43),(23,'PUSH','MIRROR',NULL,46),(24,'EAST',NULL,NULL,NULL),(25,'OPEN','WARDROBE',NULL,50),(26,'INSERT','EARRING','PAINTING',51),(27,'EAST',NULL,NULL,NULL),(28,'CUT','ROPE','SPEAR',58),(29,'WEST',NULL,NULL,59),(30,'CLIMB','LADDER',NULL,60);
/*!40000 ALTER TABLE `game_logic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_object`
--

DROP TABLE IF EXISTS `game_object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_object` (
  `id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `room_id` int(11) NOT NULL,
  `openable` tinyint(1) DEFAULT NULL,
  `pickable` tinyint(1) DEFAULT NULL,
  `pushable` tinyint(1) DEFAULT NULL,
  `is_container` tinyint(1) DEFAULT NULL,
  `description` int(11) DEFAULT NULL,
  `visible` tinyint(1) DEFAULT NULL,
  `where_contained` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_object`
--

LOCK TABLES `game_object` WRITE;
/*!40000 ALTER TABLE `game_object` DISABLE KEYS */;
INSERT INTO `game_object` VALUES (1,'ORANGE_CRYSTAL',2,0,1,0,0,68,1,2),(2,'SETTLE',2,1,0,0,1,10,1,NULL),(3,'RADIO',3,0,1,0,0,14,1,NULL),(4,'ALTAR',4,1,0,0,1,17,1,NULL),(5,'HANDLE',4,0,1,0,0,70,1,4),(6,'EST_GEAR',6,0,0,0,0,25,1,NULL),(7,'WEST_GEAR',6,0,0,1,0,25,1,NULL),(8,'KNIFE',7,0,1,0,0,71,1,28),(9,'TABLE_LEG',7,0,1,0,0,29,1,28),(10,'BUTTON',7,0,0,1,0,28,1,NULL),(11,'DRAWER',9,1,0,0,1,35,1,NULL),(12,'JAR',9,0,1,0,0,72,1,11),(13,'KEY',9,0,1,0,0,73,1,11),(14,'GREEN_CRYSTAL',10,0,1,0,0,74,1,NULL),(15,'MIRROR',11,0,0,1,0,75,1,NULL),(16,'WARDROBE',12,1,0,0,1,84,1,NULL),(17,'EARRING',12,0,1,0,0,76,1,16),(18,'SWORD',13,0,1,0,0,77,1,31),(19,'IVY',8,0,0,0,0,31,1,NULL),(20,'PAINTING',12,0,0,0,0,49,1,NULL),(21,'SPEAR',13,0,1,0,0,78,1,31),(22,'REFLEX_HANDLE',11,0,0,0,0,83,1,NULL),(23,'WIND_STAR',1,0,0,0,0,6,1,NULL),(24,'STONE_TABLE',2,0,0,0,0,8,1,NULL),(25,'CHAIRS',2,0,0,0,0,9,1,NULL),(26,'WINDOW',4,0,0,0,0,18,1,NULL),(27,'BED',5,0,0,0,0,81,1,NULL),(28,'WALL_UNIT',7,1,0,0,1,27,1,NULL),(29,'BROKEN_TABLE',7,0,0,0,0,82,1,NULL),(30,'CUPBOARD',9,1,0,0,0,34,1,NULL),(31,'ARMOR',13,0,0,0,1,54,1,NULL),(32,'WEAPONS',14,0,0,0,0,56,1,NULL),(33,'MEDIEVAL_RAM',14,0,0,0,0,85,1,NULL),(34,'ROPE',15,0,0,0,0,86,1,NULL),(35,'LADDER',1,0,0,0,0,80,0,NULL),(36,'GHOST',10,0,0,0,0,88,1,NULL),(37,'DOOR',4,0,0,1,0,89,1,NULL);
/*!40000 ALTER TABLE `game_object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rooms` (
  `id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `north` int(11) DEFAULT NULL,
  `south` int(11) DEFAULT NULL,
  `east` int(11) DEFAULT NULL,
  `west` int(11) DEFAULT NULL,
  `description` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,'stanza con stella dei venti',NULL,29,1,2,3),(2,'stanza a forma di ottagono',NULL,3,NULL,4,7),(3,'stanza segreta',5,6,NULL,NULL,12),(4,'stanza con altare',7,NULL,8,NULL,16),(5,'stanza del prete',10,NULL,NULL,9,19),(6,'stanza ellittica',NULL,11,12,NULL,21),(7,'vecchia cucina',NULL,14,NULL,13,26),(8,'stanza vegetazione',15,NULL,NULL,16,30),(9,'stanza da pranzo',18,NULL,17,NULL,33),(10,'stanza del fantasma',20,19,NULL,NULL,38),(11,'grande soggiorno',NULL,21,NULL,22,44),(12,'stanza con affresco',NULL,NULL,23,24,47),(13,'stanza delle armature',NULL,26,25,NULL,53),(14,'stanza delle armi',27,NULL,28,NULL,55);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useless_words`
--

DROP TABLE IF EXISTS `useless_words`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useless_words` (
  `word` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useless_words`
--

LOCK TABLES `useless_words` WRITE;
/*!40000 ALTER TABLE `useless_words` DISABLE KEYS */;
INSERT INTO `useless_words` VALUES ('di'),('a'),('da'),('in'),('con'),('su'),('per'),('tra'),('fra'),('il'),('lo'),('la'),('i'),('gli'),('le'),('vai'),('muoviti'),('procedi');
/*!40000 ALTER TABLE `useless_words` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-01 19:55:53
