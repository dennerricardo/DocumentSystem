# DocumentSystem
A hands-on Java project to study the Liskov Substitution Principle (LSP) through deliberate violations and step-by-step refactoring.


 
---

## What this project is

This is not a production system. It is a **learning environment** where each branch introduces one LSP violation into the Document Management System (DMS) from the book, lets you observe the failure, and then shows the correct fix.

The scenario: Dr. Avaj needs software to import and manage patient documents — images, letters, and reports. The core design is an `Importer` interface implemented by three concrete importers. LSP is what keeps those implementations safely substitutable.


---

## Project structure

```
DocumentSystem/
├── src/
   └── main/
       ├── Importer.java
       ├── Document.java
       ├── ImageImporter.java
       ├── LetterImporter.java
       ├── ReportImporter.java
       ├── DocumentManagementSystem.java
       └── Main.java


```
 
---

## Violations covered

Each violation is self-contained. Switch between them by editing the relevant class, recompiling, and running `Main`.

### Violation 1 — Strengthened precondition

**File:** `ImageImporter.java`

The interface contract says "accept any `File`." The broken version adds an extension check that rejects non-`.jpg` files, narrowing what callers are allowed to pass.

| | Broken | Fixed |
|---|---|---|
| Precondition | Only `.jpg` files | Any `File` (routing handled upstream) |
| Symptom | `IllegalArgumentException` at runtime | Imports correctly |
 
---

### Violation 2 — Weakened postcondition

**File:** `LetterImporter.java`

The interface contract implies a fully populated `Document` is returned. The broken version omits `path` and `patient`, returning less than what callers reasonably depend on.

| | Broken | Fixed |
|---|---|---|
| Postcondition | Only `type` attribute set | All required attributes populated |
| Symptom | `NullPointerException` downstream | Document attributes all accessible |
 
---

### Violation 3 — Broken invariant
**File:** `MutableDocument.java`

`Document` guarantees immutability after construction. The broken version subclasses it to add a `setAttribute()` method, allowing records to be silently corrupted after import.

| | Broken | Fixed |
|---|---|---|
| Invariant | Mutability introduced via subclass | Immutability preserved; new state = new object |
| Symptom | Two references to same object return different values | Object state never changes after construction |
 
---

### Violation 4 — History rule
 
---

## Key concepts

| Term | Meaning |
|---|---|
| **Precondition** | What a method requires from its caller before running |
| **Postcondition** | What a method guarantees to deliver when it returns |
| **Invariant** | A property that must always be true about an object's state |
| **History rule** | A subclass must not allow state transitions the parent type forbids |
 
---

## References

- *Real-World Software Development* — Urma & Warburton, O'Reilly 2019, Chapter 4
- Barbara Liskov, "Data Abstraction and Hierarchy", OOPSLA 1987

 