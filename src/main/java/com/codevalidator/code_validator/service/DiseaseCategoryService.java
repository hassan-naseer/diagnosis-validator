package com.codevalidator.code_validator.service;


import com.codevalidator.code_validator.model.CodeRange;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiseaseCategoryService {
    
    private List<CodeRange> diseaseCategories = new ArrayList<>();
    
    @PostConstruct
    public void initializeCategories() {
        System.out.println("Initializing ICD-10 disease categories...");
        loadAllCategories();
        System.out.println("Loaded " + diseaseCategories.size() + " disease categories");

        // Calling the test
        testCategories();
    }
    
    private void loadAllCategories() {
        // CHAPTER A: Certain infectious and parasitic diseases (A00-B99)
        diseaseCategories.add(new CodeRange("A00", "A09", "Intestinal infectious diseases", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("A15", "A19", "Tuberculosis", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("A20", "A28", "Certain zoonotic bacterial diseases", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("A30", "A49", "Other bacterial diseases", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("A50", "A64", "Infections with a predominantly sexual mode of transmission", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("A65", "A69", "Other spirochetal diseases", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("A70", "A74", "Other diseases caused by chlamydiae", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("A75", "A79", "Rickettsioses", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("A80", "A89", "Viral infections of the central nervous system", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("A90", "A99", "Arthropod-borne viral fevers and viral hemorrhagic fevers", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("B00", "B09", "Viral infections characterized by skin and mucous membrane lesions", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("B10", "B10", "Other human herpesviruses", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("B15", "B19", "Viral hepatitis", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("B20", "B20", "Human immunodeficiency virus [HIV] disease", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("B25", "B34", "Other viral diseases", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("B35", "B49", "Mycoses", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("B50", "B64", "Protozoal diseases", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("B65", "B83", "Helminthiases", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("B85", "B89", "Pediculosis, acariasis and other infestations", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("B90", "B94", "Sequelae of infectious and parasitic diseases", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("B95", "B97", "Bacterial and viral infectious agents", "Infectious and parasitic diseases"));
        diseaseCategories.add(new CodeRange("B99", "B99", "Other infectious diseases", "Infectious and parasitic diseases"));
        
        // CHAPTER C: Neoplasms (C00-D49)
        diseaseCategories.add(new CodeRange("C00", "C14", "Malignant neoplasms of lip, oral cavity and pharynx", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C15", "C26", "Malignant neoplasms of digestive organs", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C30", "C39", "Malignant neoplasms of respiratory and intrathoracic organs", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C40", "C41", "Malignant neoplasms of bone and articular cartilage", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C43", "C44", "Melanoma and other malignant neoplasms of skin", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C45", "C49", "Malignant neoplasms of mesothelial and soft tissue", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C50", "C50", "Malignant neoplasms of breast", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C51", "C58", "Malignant neoplasms of female genital organs", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C60", "C63", "Malignant neoplasms of male genital organs", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C64", "C68", "Malignant neoplasms of urinary tract", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C69", "C72", "Malignant neoplasms of eye, brain and other parts of central nervous system", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C73", "C75", "Malignant neoplasms of thyroid and other endocrine glands", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C76", "C80", "Malignant neoplasms of ill-defined, other secondary and unspecified sites", "Neoplasms"));
        diseaseCategories.add(new CodeRange("C81", "C96", "Malignant neoplasms of lymphoid, hematopoietic and related tissue", "Neoplasms"));
        diseaseCategories.add(new CodeRange("D00", "D09", "In situ neoplasms", "Neoplasms"));
        diseaseCategories.add(new CodeRange("D10", "D36", "Benign neoplasms", "Neoplasms"));
        diseaseCategories.add(new CodeRange("D37", "D48", "Neoplasms of uncertain behavior", "Neoplasms"));
        diseaseCategories.add(new CodeRange("D49", "D49", "Neoplasms of unspecified behavior", "Neoplasms"));
        
        // CHAPTER D: Diseases of the blood and blood-forming organs (D50-D89)
        diseaseCategories.add(new CodeRange("D50", "D53", "Nutritional anemias", "Diseases of the blood and blood-forming organs"));
        diseaseCategories.add(new CodeRange("D55", "D59", "Hemolytic anemias", "Diseases of the blood and blood-forming organs"));
        diseaseCategories.add(new CodeRange("D60", "D64", "Aplastic and other anemias and other bone marrow failure syndromes", "Diseases of the blood and blood-forming organs"));
        diseaseCategories.add(new CodeRange("D65", "D69", "Coagulation defects, purpura and other hemorrhagic conditions", "Diseases of the blood and blood-forming organs"));
        diseaseCategories.add(new CodeRange("D70", "D77", "Other disorders of blood and blood-forming organs", "Diseases of the blood and blood-forming organs"));
        diseaseCategories.add(new CodeRange("D78", "D78", "Intraoperative and postprocedural complications of the spleen", "Diseases of the blood and blood-forming organs"));
        diseaseCategories.add(new CodeRange("D80", "D89", "Certain disorders involving the immune mechanism", "Diseases of the blood and blood-forming organs"));
        
        // CHAPTER E: Endocrine, nutritional and metabolic diseases (E00-E89)
        diseaseCategories.add(new CodeRange("E00", "E07", "Disorders of thyroid gland", "Endocrine, nutritional and metabolic diseases"));
        diseaseCategories.add(new CodeRange("E08", "E13", "Diabetes mellitus", "Endocrine, nutritional and metabolic diseases"));
        diseaseCategories.add(new CodeRange("E15", "E16", "Other disorders of glucose regulation and pancreatic internal secretion", "Endocrine, nutritional and metabolic diseases"));
        diseaseCategories.add(new CodeRange("E20", "E35", "Disorders of other endocrine glands", "Endocrine, nutritional and metabolic diseases"));
        diseaseCategories.add(new CodeRange("E36", "E36", "Intraoperative complications of endocrine system", "Endocrine, nutritional and metabolic diseases"));
        diseaseCategories.add(new CodeRange("E40", "E46", "Malnutrition", "Endocrine, nutritional and metabolic diseases"));
        diseaseCategories.add(new CodeRange("E50", "E64", "Other nutritional deficiencies", "Endocrine, nutritional and metabolic diseases"));
        diseaseCategories.add(new CodeRange("E65", "E68", "Overweight, obesity and other hyperalimentation", "Endocrine, nutritional and metabolic diseases"));
        diseaseCategories.add(new CodeRange("E70", "E88", "Metabolic disorders", "Endocrine, nutritional and metabolic diseases"));
        diseaseCategories.add(new CodeRange("E89", "E89", "Postprocedural endocrine and metabolic complications and disorders", "Endocrine, nutritional and metabolic diseases"));
        
        // CHAPTER F: Mental, Behavioral and Neurodevelopmental disorders (F01-F99)
        diseaseCategories.add(new CodeRange("F01", "F09", "Mental disorders due to known physiological conditions", "Mental, Behavioral and Neurodevelopmental disorders"));
        diseaseCategories.add(new CodeRange("F10", "F19", "Mental and behavioral disorders due to psychoactive substance use", "Mental, Behavioral and Neurodevelopmental disorders"));
        diseaseCategories.add(new CodeRange("F20", "F29", "Schizophrenia, schizotypal, delusional, and other non-mood psychotic disorders", "Mental, Behavioral and Neurodevelopmental disorders"));
        diseaseCategories.add(new CodeRange("F30", "F39", "Mood [affective] disorders", "Mental, Behavioral and Neurodevelopmental disorders"));
        diseaseCategories.add(new CodeRange("F40", "F48", "Anxiety, dissociative, stress-related, somatoform and other nonpsychotic mental disorders", "Mental, Behavioral and Neurodevelopmental disorders"));
        diseaseCategories.add(new CodeRange("F50", "F59", "Behavioral syndromes associated with physiological disturbances and physical factors", "Mental, Behavioral and Neurodevelopmental disorders"));
        diseaseCategories.add(new CodeRange("F60", "F69", "Disorders of adult personality and behavior", "Mental, Behavioral and Neurodevelopmental disorders"));
        diseaseCategories.add(new CodeRange("F70", "F79", "Intellectual disabilities", "Mental, Behavioral and Neurodevelopmental disorders"));
        diseaseCategories.add(new CodeRange("F80", "F89", "Pervasive and specific developmental disorders", "Mental, Behavioral and Neurodevelopmental disorders"));
        diseaseCategories.add(new CodeRange("F90", "F98", "Behavioral and emotional disorders with onset usually occurring in childhood and adolescence", "Mental, Behavioral and Neurodevelopmental disorders"));
        diseaseCategories.add(new CodeRange("F99", "F99", "Unspecified mental disorder", "Mental, Behavioral and Neurodevelopmental disorders"));
        
        // CHAPTER G: Diseases of the nervous system (G00-G99)
        diseaseCategories.add(new CodeRange("G00", "G09", "Inflammatory diseases of the central nervous system", "Diseases of the nervous system"));
        diseaseCategories.add(new CodeRange("G10", "G14", "Systemic atrophies primarily affecting the central nervous system", "Diseases of the nervous system"));
        diseaseCategories.add(new CodeRange("G20", "G26", "Extrapyramidal and movement disorders", "Diseases of the nervous system"));
        diseaseCategories.add(new CodeRange("G30", "G32", "Other degenerative diseases of the nervous system", "Diseases of the nervous system"));
        diseaseCategories.add(new CodeRange("G35", "G37", "Demyelinating diseases of the central nervous system", "Diseases of the nervous system"));
        diseaseCategories.add(new CodeRange("G40", "G47", "Episodic and paroxysmal disorders", "Diseases of the nervous system"));
        diseaseCategories.add(new CodeRange("G50", "G59", "Nerve, nerve root and plexus disorders", "Diseases of the nervous system"));
        diseaseCategories.add(new CodeRange("G60", "G65", "Polyneuropathies and other disorders of the peripheral nervous system", "Diseases of the nervous system"));
        diseaseCategories.add(new CodeRange("G70", "G73", "Diseases of myoneural junction and muscle", "Diseases of the nervous system"));
        diseaseCategories.add(new CodeRange("G80", "G83", "Cerebral palsy and other paralytic syndromes", "Diseases of the nervous system"));
        diseaseCategories.add(new CodeRange("G89", "G99", "Other disorders of the nervous system", "Diseases of the nervous system"));
        
        // CHAPTER H: Diseases of the eye and adnexa (H00-H59)
        diseaseCategories.add(new CodeRange("H00", "H05", "Disorders of eyelid, lacrimal system and orbit", "Diseases of the eye and adnexa"));
        diseaseCategories.add(new CodeRange("H10", "H11", "Disorders of conjunctiva", "Diseases of the eye and adnexa"));
        diseaseCategories.add(new CodeRange("H15", "H22", "Disorders of sclera, cornea, iris and ciliary body", "Diseases of the eye and adnexa"));
        diseaseCategories.add(new CodeRange("H25", "H28", "Disorders of lens", "Diseases of the eye and adnexa"));
        diseaseCategories.add(new CodeRange("H30", "H36", "Disorders of choroid and retina", "Diseases of the eye and adnexa"));
        diseaseCategories.add(new CodeRange("H40", "H42", "Glaucoma", "Diseases of the eye and adnexa"));
        diseaseCategories.add(new CodeRange("H43", "H44", "Disorders of vitreous body and globe", "Diseases of the eye and adnexa"));
        diseaseCategories.add(new CodeRange("H46", "H47", "Disorders of optic nerve and visual pathways", "Diseases of the eye and adnexa"));
        diseaseCategories.add(new CodeRange("H49", "H52", "Disorders of ocular muscles, binocular movement, accommodation and refraction", "Diseases of the eye and adnexa"));
        diseaseCategories.add(new CodeRange("H53", "H54", "Visual disturbances and blindness", "Diseases of the eye and adnexa"));
        diseaseCategories.add(new CodeRange("H55", "H57", "Other disorders of eye and adnexa", "Diseases of the eye and adnexa"));
        diseaseCategories.add(new CodeRange("H59", "H59", "Intraoperative and postprocedural complications and disorders of eye and adnexa", "Diseases of the eye and adnexa"));
        
        // CHAPTER H: Diseases of the ear and mastoid process (H60-H95)
        diseaseCategories.add(new CodeRange("H60", "H62", "Diseases of external ear", "Diseases of the ear and mastoid process"));
        diseaseCategories.add(new CodeRange("H65", "H75", "Diseases of middle ear and mastoid", "Diseases of the ear and mastoid process"));
        diseaseCategories.add(new CodeRange("H80", "H83", "Diseases of inner ear", "Diseases of the ear and mastoid process"));
        diseaseCategories.add(new CodeRange("H90", "H94", "Other disorders of ear", "Diseases of the ear and mastoid process"));
        diseaseCategories.add(new CodeRange("H95", "H95", "Intraoperative and postprocedural complications and disorders of ear and mastoid process", "Diseases of the ear and mastoid process"));
        
        // CHAPTER I: Diseases of the circulatory system (I00-I99)
        diseaseCategories.add(new CodeRange("I00", "I02", "Acute rheumatic fever", "Diseases of the circulatory system"));
        diseaseCategories.add(new CodeRange("I05", "I09", "Chronic rheumatic heart diseases", "Diseases of the circulatory system"));
        diseaseCategories.add(new CodeRange("I10", "I16", "Hypertensive diseases", "Diseases of the circulatory system"));
        diseaseCategories.add(new CodeRange("I20", "I25", "Ischemic heart diseases", "Diseases of the circulatory system"));
        diseaseCategories.add(new CodeRange("I26", "I28", "Pulmonary heart disease and diseases of pulmonary circulation", "Diseases of the circulatory system"));
        diseaseCategories.add(new CodeRange("I30", "I5A", "Other forms of heart disease", "Diseases of the circulatory system"));
        diseaseCategories.add(new CodeRange("I60", "I69", "Cerebrovascular diseases", "Diseases of the circulatory system"));
        diseaseCategories.add(new CodeRange("I70", "I79", "Diseases of arteries, arterioles and capillaries", "Diseases of the circulatory system"));
        diseaseCategories.add(new CodeRange("I80", "I89", "Diseases of veins, lymphatic vessels and lymph nodes", "Diseases of the circulatory system"));
        diseaseCategories.add(new CodeRange("I95", "I99", "Other and unspecified disorders of the circulatory system", "Diseases of the circulatory system"));
        
        // CHAPTER J: Diseases of the respiratory system (J00-J99)
        diseaseCategories.add(new CodeRange("J00", "J06", "Acute upper respiratory infections", "Diseases of the respiratory system"));
        diseaseCategories.add(new CodeRange("J09", "J18", "Influenza and pneumonia", "Diseases of the respiratory system"));
        diseaseCategories.add(new CodeRange("J20", "J22", "Other acute lower respiratory infections", "Diseases of the respiratory system"));
        diseaseCategories.add(new CodeRange("J30", "J39", "Other diseases of upper respiratory tract", "Diseases of the respiratory system"));
        diseaseCategories.add(new CodeRange("J40", "J47", "Chronic lower respiratory diseases", "Diseases of the respiratory system"));
        diseaseCategories.add(new CodeRange("J60", "J70", "Lung diseases due to external agents", "Diseases of the respiratory system"));
        diseaseCategories.add(new CodeRange("J80", "J84", "Other respiratory diseases principally affecting the interstitium", "Diseases of the respiratory system"));
        diseaseCategories.add(new CodeRange("J85", "J86", "Suppurative and necrotic conditions of the lower respiratory tract", "Diseases of the respiratory system"));
        diseaseCategories.add(new CodeRange("J90", "J94", "Other diseases of the pleura", "Diseases of the respiratory system"));
        diseaseCategories.add(new CodeRange("J95", "J95", "Intraoperative and postprocedural complications and disorders of respiratory system", "Diseases of the respiratory system"));
        diseaseCategories.add(new CodeRange("J96", "J99", "Other diseases of the respiratory system", "Diseases of the respiratory system"));
        
        // CHAPTER K: Diseases of the digestive system (K00-K95)
        diseaseCategories.add(new CodeRange("K00", "K14", "Diseases of oral cavity and salivary glands", "Diseases of the digestive system"));
        diseaseCategories.add(new CodeRange("K20", "K31", "Diseases of esophagus, stomach and duodenum", "Diseases of the digestive system"));
        diseaseCategories.add(new CodeRange("K35", "K38", "Diseases of appendix", "Diseases of the digestive system"));
        diseaseCategories.add(new CodeRange("K40", "K46", "Hernia", "Diseases of the digestive system"));
        diseaseCategories.add(new CodeRange("K50", "K52", "Noninfective enteritis and colitis", "Diseases of the digestive system"));
        diseaseCategories.add(new CodeRange("K55", "K64", "Other diseases of intestines", "Diseases of the digestive system"));
        diseaseCategories.add(new CodeRange("K65", "K68", "Diseases of peritoneum and retroperitoneum", "Diseases of the digestive system"));
        diseaseCategories.add(new CodeRange("K70", "K77", "Diseases of liver", "Diseases of the digestive system"));
        diseaseCategories.add(new CodeRange("K80", "K87", "Disorders of gallbladder, biliary tract and pancreas", "Diseases of the digestive system"));
        diseaseCategories.add(new CodeRange("K90", "K95", "Other diseases of the digestive system", "Diseases of the digestive system"));
        
        // CHAPTER L: Diseases of the skin and subcutaneous tissue (L00-L99)
        diseaseCategories.add(new CodeRange("L00", "L08", "Infections of the skin and subcutaneous tissue", "Diseases of the skin and subcutaneous tissue"));
        diseaseCategories.add(new CodeRange("L10", "L14", "Bullous disorders", "Diseases of the skin and subcutaneous tissue"));
        diseaseCategories.add(new CodeRange("L20", "L30", "Dermatitis and eczema", "Diseases of the skin and subcutaneous tissue"));
        diseaseCategories.add(new CodeRange("L40", "L45", "Papulosquamous disorders", "Diseases of the skin and subcutaneous tissue"));
        diseaseCategories.add(new CodeRange("L49", "L54", "Urticaria and erythema", "Diseases of the skin and subcutaneous tissue"));
        diseaseCategories.add(new CodeRange("L55", "L59", "Radiation-related disorders of the skin and subcutaneous tissue", "Diseases of the skin and subcutaneous tissue"));
        diseaseCategories.add(new CodeRange("L60", "L75", "Disorders of skin appendages", "Diseases of the skin and subcutaneous tissue"));
        diseaseCategories.add(new CodeRange("L76", "L76", "Intraoperative and postprocedural complications of skin and subcutaneous tissue", "Diseases of the skin and subcutaneous tissue"));
        diseaseCategories.add(new CodeRange("L80", "L99", "Other disorders of the skin and subcutaneous tissue", "Diseases of the skin and subcutaneous tissue"));
        
        // CHAPTER M: Diseases of the musculoskeletal system and connective tissue (M00-M99)
        diseaseCategories.add(new CodeRange("M00", "M02", "Infectious arthropathies", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M05", "M14", "Inflammatory polyarthropathies", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M15", "M19", "Osteoarthritis", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M20", "M25", "Other joint disorders", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M26", "M27", "Dentofacial anomalies and other disorders of jaw", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M30", "M36", "Systemic connective tissue disorders", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M40", "M43", "Deforming dorsopathies", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M45", "M49", "Spondylopathies", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M50", "M54", "Other dorsopathies", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M60", "M63", "Disorders of muscles", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M65", "M67", "Disorders of synovium and tendon", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M70", "M79", "Other soft tissue disorders", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M80", "M85", "Disorders of bone density and structure", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M86", "M90", "Other osteopathies", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M91", "M94", "Chondropathies", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M95", "M95", "Other disorders of the musculoskeletal system and connective tissue", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M96", "M96", "Intraoperative and postprocedural complications and disorders of musculoskeletal system", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M97", "M97", "Periprosthetic fracture around internal prosthetic joint", "Diseases of the musculoskeletal system and connective tissue"));
        diseaseCategories.add(new CodeRange("M99", "M99", "Biomechanical lesions", "Diseases of the musculoskeletal system and connective tissue"));
        
        // CHAPTER N: Diseases of the genitourinary system (N00-N99)
        diseaseCategories.add(new CodeRange("N00", "N08", "Glomerular diseases", "Diseases of the genitourinary system"));
        diseaseCategories.add(new CodeRange("N10", "N16", "Renal tubulo-interstitial diseases", "Diseases of the genitourinary system"));
        diseaseCategories.add(new CodeRange("N17", "N19", "Acute kidney failure and chronic kidney disease", "Diseases of the genitourinary system"));
        diseaseCategories.add(new CodeRange("N20", "N23", "Urolithiasis", "Diseases of the genitourinary system"));
        diseaseCategories.add(new CodeRange("N25", "N29", "Other disorders of kidney and ureter", "Diseases of the genitourinary system"));
        diseaseCategories.add(new CodeRange("N30", "N39", "Other diseases of the urinary system", "Diseases of the genitourinary system"));
        diseaseCategories.add(new CodeRange("N40", "N53", "Diseases of male genital organs", "Diseases of the genitourinary system"));
        diseaseCategories.add(new CodeRange("N60", "N65", "Disorders of breast", "Diseases of the genitourinary system"));
        diseaseCategories.add(new CodeRange("N70", "N77", "Inflammatory diseases of female pelvic organs", "Diseases of the genitourinary system"));
        diseaseCategories.add(new CodeRange("N80", "N98", "Noninflammatory disorders of female genital tract", "Diseases of the genitourinary system"));
        diseaseCategories.add(new CodeRange("N99", "N99", "Intraoperative and postprocedural complications and disorders of genitourinary system", "Diseases of the genitourinary system"));
        
        // CHAPTER O: Pregnancy, childbirth and the puerperium (O00-O9A)
        diseaseCategories.add(new CodeRange("O00", "O08", "Pregnancy with abortive outcome", "Pregnancy, childbirth and the puerperium"));
        diseaseCategories.add(new CodeRange("O09", "O09", "Supervision of high risk pregnancy", "Pregnancy, childbirth and the puerperium"));
        diseaseCategories.add(new CodeRange("O10", "O16", "Edema, proteinuria and hypertensive disorders in pregnancy, childbirth and the puerperium", "Pregnancy, childbirth and the puerperium"));
        diseaseCategories.add(new CodeRange("O20", "O29", "Other maternal disorders predominantly related to pregnancy", "Pregnancy, childbirth and the puerperium"));
        diseaseCategories.add(new CodeRange("O30", "O48", "Maternal care related to the fetus and amniotic cavity and possible delivery problems", "Pregnancy, childbirth and the puerperium"));
        diseaseCategories.add(new CodeRange("O60", "O77", "Complications of labor and delivery", "Pregnancy, childbirth and the puerperium"));
        diseaseCategories.add(new CodeRange("O80", "O82", "Encounter for delivery", "Pregnancy, childbirth and the puerperium"));
        diseaseCategories.add(new CodeRange("O85", "O92", "Complications predominantly related to the puerperium", "Pregnancy, childbirth and the puerperium"));
        diseaseCategories.add(new CodeRange("O94", "O9A", "Other obstetric conditions", "Pregnancy, childbirth and the puerperium"));
        
        // CHAPTER P: Certain conditions originating in the perinatal period (P00-P96)
        diseaseCategories.add(new CodeRange("P00", "P04", "Newborn affected by maternal factors and by complications of pregnancy, labor, and delivery", "Certain conditions originating in the perinatal period"));
        diseaseCategories.add(new CodeRange("P05", "P08", "Disorders of newborn related to length of gestation and fetal growth", "Certain conditions originating in the perinatal period"));
        diseaseCategories.add(new CodeRange("P09", "P09", "Abnormal findings on neonatal screening", "Certain conditions originating in the perinatal period"));
        diseaseCategories.add(new CodeRange("P10", "P15", "Birth trauma", "Certain conditions originating in the perinatal period"));
        diseaseCategories.add(new CodeRange("P19", "P29", "Respiratory and cardiovascular disorders specific to the perinatal period", "Certain conditions originating in the perinatal period"));
        diseaseCategories.add(new CodeRange("P35", "P39", "Infections specific to the perinatal period", "Certain conditions originating in the perinatal period"));
        diseaseCategories.add(new CodeRange("P50", "P61", "Hemorrhagic and hematological disorders of newborn", "Certain conditions originating in the perinatal period"));
        diseaseCategories.add(new CodeRange("P70", "P74", "Transitory endocrine and metabolic disorders specific to newborn", "Certain conditions originating in the perinatal period"));
        diseaseCategories.add(new CodeRange("P76", "P78", "Digestive system disorders of newborn", "Certain conditions originating in the perinatal period"));
        diseaseCategories.add(new CodeRange("P80", "P83", "Conditions involving the integument and temperature regulation of newborn", "Certain conditions originating in the perinatal period"));
        diseaseCategories.add(new CodeRange("P84", "P84", "Other problems with newborn", "Certain conditions originating in the perinatal period"));
        diseaseCategories.add(new CodeRange("P90", "P96", "Other disorders originating in the perinatal period", "Certain conditions originating in the perinatal period"));
        
        // CHAPTER Q: Congenital malformations, deformations and chromosomal abnormalities (Q00-Q99)
        diseaseCategories.add(new CodeRange("Q00", "Q07", "Congenital malformations of the nervous system", "Congenital malformations, deformations and chromosomal abnormalities"));
        diseaseCategories.add(new CodeRange("Q10", "Q18", "Congenital malformations of eye, ear, face and neck", "Congenital malformations, deformations and chromosomal abnormalities"));
        diseaseCategories.add(new CodeRange("Q20", "Q28", "Congenital malformations of the circulatory system", "Congenital malformations, deformations and chromosomal abnormalities"));
        diseaseCategories.add(new CodeRange("Q30", "Q34", "Congenital malformations of the respiratory system", "Congenital malformations, deformations and chromosomal abnormalities"));
        diseaseCategories.add(new CodeRange("Q35", "Q37", "Cleft lip and cleft palate", "Congenital malformations, deformations and chromosomal abnormalities"));
        diseaseCategories.add(new CodeRange("Q38", "Q45", "Other congenital malformations of the digestive system", "Congenital malformations, deformations and chromosomal abnormalities"));
        diseaseCategories.add(new CodeRange("Q50", "Q56", "Congenital malformations of genital organs", "Congenital malformations, deformations and chromosomal abnormalities"));
        diseaseCategories.add(new CodeRange("Q60", "Q64", "Congenital malformations of the urinary system", "Congenital malformations, deformations and chromosomal abnormalities"));
        diseaseCategories.add(new CodeRange("Q65", "Q79", "Congenital malformations and deformations of the musculoskeletal system", "Congenital malformations, deformations and chromosomal abnormalities"));
        diseaseCategories.add(new CodeRange("Q80", "Q89", "Other congenital malformations", "Congenital malformations, deformations and chromosomal abnormalities"));
        diseaseCategories.add(new CodeRange("Q90", "Q99", "Chromosomal abnormalities", "Congenital malformations, deformations and chromosomal abnormalities"));
        
        // CHAPTER R: Symptoms, signs and abnormal clinical and laboratory findings (R00-R99)
        diseaseCategories.add(new CodeRange("R00", "R09", "Symptoms and signs involving the circulatory and respiratory systems", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R10", "R19", "Symptoms and signs involving the digestive system and abdomen", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R20", "R23", "Symptoms and signs involving the skin and subcutaneous tissue", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R25", "R29", "Symptoms and signs involving the nervous and musculoskeletal systems", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R30", "R39", "Symptoms and signs involving the genitourinary system", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R40", "R46", "Symptoms and signs involving cognition, perception, emotional state and behavior", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R47", "R49", "Symptoms and signs involving speech and voice", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R50", "R69", "General symptoms and signs", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R70", "R79", "Abnormal findings on examination of blood", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R80", "R82", "Abnormal findings on examination of urine", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R83", "R89", "Abnormal findings on examination of other body fluids, substances and tissues", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R90", "R94", "Abnormal findings on diagnostic imaging and in function studies", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R97", "R97", "Abnormal tumor markers", "Symptoms, signs and abnormal clinical and laboratory findings"));
        diseaseCategories.add(new CodeRange("R99", "R99", "Ill-defined and unknown cause of mortality", "Symptoms, signs and abnormal clinical and laboratory findings"));
        
        // CHAPTER S/T: Injury, poisoning and certain other consequences of external causes (S00-T88)
        diseaseCategories.add(new CodeRange("S00", "S09", "Injuries to the head", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("S10", "S19", "Injuries to the neck", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("S20", "S29", "Injuries to the thorax", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("S30", "S39", "Injuries to the abdomen, lower back, lumbar spine, pelvis and external genitals", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("S40", "S49", "Injuries to the shoulder and upper arm", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("S50", "S59", "Injuries to the elbow and forearm", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("S60", "S69", "Injuries to the wrist, hand and fingers", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("S70", "S79", "Injuries to the hip and thigh", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("S80", "S89", "Injuries to the knee and lower leg", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("S90", "S99", "Injuries to the ankle and foot", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("T07", "T07", "Injuries involving multiple body regions", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("T14", "T14", "Injury of unspecified body region", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("T15", "T19", "Effects of foreign body entering through natural orifice", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("T20", "T25", "Burns and corrosions of external body surface", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("T26", "T28", "Burns and corrosions confined to eye and internal organs", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("T30", "T32", "Burns and corrosions of multiple and unspecified body regions", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("T33", "T34", "Frostbite", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("T36", "T50", "Poisoning by, adverse effects of and underdosing of drugs, medicaments and biological substances", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("T51", "T65", "Toxic effects of substances chiefly nonmedicinal as to source", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("T66", "T78", "Other and unspecified effects of external causes", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("T79", "T79", "Certain early complications of trauma", "Injury, poisoning and certain other consequences of external causes"));
        diseaseCategories.add(new CodeRange("T80", "T88", "Complications of surgical and medical care", "Injury, poisoning and certain other consequences of external causes"));
        
        // CHAPTER V-Y: External causes of morbidity (V00-Y99)
        diseaseCategories.add(new CodeRange("V00", "V99", "Transport accidents", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("W00", "W19", "Slipping, tripping, stumbling and falls", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("W20", "W49", "Exposure to inanimate mechanical forces", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("W50", "W64", "Exposure to animate mechanical forces", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("W65", "W74", "Accidental non-transport drowning and submersion", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("W85", "W99", "Exposure to electric current, radiation and extreme ambient air temperature and pressure", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("X00", "X08", "Exposure to smoke, fire and flames", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("X10", "X19", "Contact with heat and hot substances", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("X30", "X39", "Exposure to forces of nature", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("X52", "X58", "Accidental exposure to other specified factors", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("X71", "X83", "Intentional self-harm", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("X92", "Y09", "Assault", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("Y21", "Y33", "Event of undetermined intent", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("Y35", "Y38", "Legal intervention, operations of war, military operations, and terrorism", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("Y62", "Y84", "Complications of medical and surgical care", "External causes of morbidity"));
        diseaseCategories.add(new CodeRange("Y90", "Y99", "Supplementary factors related to causes of morbidity classified elsewhere", "External causes of morbidity"));
        
        // CHAPTER Z: Factors influencing health status and contact with health services (Z00-Z99)
        diseaseCategories.add(new CodeRange("Z00", "Z13", "Persons encountering health services for examinations", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z14", "Z15", "Genetic carrier and genetic susceptibility to disease", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z16", "Z16", "Resistance to antimicrobial drugs", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z17", "Z17", "Estrogen receptor status", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z18", "Z18", "Retained foreign body fragments", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z19", "Z19", "Hormone sensitivity malignancy status", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z20", "Z29", "Persons with potential health hazards related to communicable diseases", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z30", "Z39", "Persons encountering health services in circumstances related to reproduction", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z40", "Z53", "Encounters for other specific health care", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z55", "Z65", "Persons with potential health hazards related to socioeconomic and psychosocial circumstances", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z66", "Z66", "Do not resuscitate status", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z67", "Z67", "Blood type", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z68", "Z68", "Body mass index [BMI]", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z69", "Z76", "Persons encountering health services in other circumstances", "Factors influencing health status and contact with health services"));
        diseaseCategories.add(new CodeRange("Z77", "Z99", "Persons with potential health hazards related to family and personal history and certain conditions influencing health status", "Factors influencing health status and contact with health services"));
    }
    
    // Find which category a code belongs to
    public CodeRange getCategoryForCode(String code) {
        for (CodeRange range : diseaseCategories) {
            if (range.contains(code)) {
                return range;
            }
        }
        return null; // Code doesn't match any category
    }
    
    // Get all categories
    public List<CodeRange> getAllCategories() {
        return diseaseCategories;
    }



    // for Testing
    public void testCategories() {
    System.out.println("\n🧪 === TESTING DISEASE CATEGORIES ===");
    
    String[] testCodes = {
        "E11.65",   // Should be: Diabetes mellitus
        "I10",      // Should be: Hypertensive diseases  
        "J44.0",    // Should be: Chronic lower respiratory diseases
        "C50.911",  // Should be: Malignant neoplasms of breast
        "M79.3",    // Should be: Other soft tissue disorders
        "A00.1"     // Should be: Intestinal infectious diseases
    };
    
    for (String code : testCodes) {
        CodeRange category = getCategoryForCode(code);
        if (category != null) {
            System.out.println(code + " → " + category.getCategory() + " (" + category.getChapter() + ")");
        } else {
            System.out.println(code + " → NOT FOUND");
        }
    }
    System.out.println("=====================================\n");
}
}