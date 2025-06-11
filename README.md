# 📦 Custom Business Exception Classes

Ce projet Java fournit une structure complète pour la gestion des exceptions métier et techniques via des classes personnalisées. Il améliore la lisibilité du code, la cohérence des erreurs et facilite le débogage dans les applications complexes ou distribuées.

## 🎯 Objectif

- Centraliser les erreurs techniques et métier
- Standardiser les messages d’erreurs avec des codes
- Offrir une gestion groupée d’erreurs (ex: validation)
- Faciliter l’intégration dans des projets Spring Boot

---

## 🗂️ Structure du projet

VOIR LE PROJET


---

## 📌 Composants principaux

### 🔹 `ExceptionCode`
Interface commune pour toutes les énumérations de code d’exception (technique ou métier).

### 🔹 `TechnicalExceptionCode`
Enum contenant les erreurs techniques :
- `TECH_00001`: Unknown technical error
- `TECH_00002`: Empty HTTP response
- `TECH_00003`: Missing API header
- `TECH_00004`: HTTP error
- etc.

### 🔹 `BusinessException`
Exception métier générique basée sur un `ExceptionCode`, utilisable dans la logique applicative.

### 🔹 `BusinessListException`
Permet d’agréger plusieurs exceptions métier dans une seule exception.

### 🔹 Exceptions spécifiques
- `ForbiddenException` → HTTP 403
- `ObjectNotFoundException` → HTTP 404
- `ServiceException` → Erreur métier applicative
- `TechnicalException` → Pour les erreurs techniques non fonctionnelles

---

## ✅ Exemple d’utilisation

```java
throw new TechnicalException(TechnicalExceptionCode.HTTP_ERROR);

throw new ObjectNotFoundException("User not found with ID: " + userId);

BusinessListException exList = new BusinessListException()
    .addException(new BusinessException(...))
    .addException(new BusinessException(...));
```

🧩 Idées d’extension

- Gestion centralisée via @ControllerAdvice dans Spring
- Feature flags dynamiques via FeatureFlagManager
- Support multilingue avec fichiers de messages

👤 Auteur

Ayoub ID-IHIA
Développeur Java
