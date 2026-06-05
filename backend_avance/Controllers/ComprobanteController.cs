using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using backend_avance.Models;

namespace backend_avance.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ComprobanteController : ControllerBase
    {
        private readonly bdavancetechContext _context;

        public ComprobanteController(bdavancetechContext context)
        {
            _context = context;
        }

        // GET: api/Comprobante
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Comprobante>>> GetComprobantes()
        {
            return await _context.Comprobantes.ToListAsync();
        }

        // GET: api/Comprobante/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Comprobante>> GetComprobante(int id)
        {
            var comprobante = await _context.Comprobantes.FindAsync(id);

            if (comprobante == null)
            {
                return NotFound();
            }

            return comprobante;
        }

        // PUT: api/Comprobante/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutComprobante(int id, Comprobante comprobante)
        {
            if (id != comprobante.IdComprobante)
            {
                return BadRequest();
            }

            _context.Entry(comprobante).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ComprobanteExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Comprobante
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Comprobante>> PostComprobante(Comprobante comprobante)
        {
            _context.Comprobantes.Add(comprobante);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (ComprobanteExists(comprobante.IdComprobante))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetComprobante", new { id = comprobante.IdComprobante }, comprobante);
        }

        // DELETE: api/Comprobante/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteComprobante(int id)
        {
            var comprobante = await _context.Comprobantes.FindAsync(id);
            if (comprobante == null)
            {
                return NotFound();
            }

            _context.Comprobantes.Remove(comprobante);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool ComprobanteExists(int id)
        {
            return _context.Comprobantes.Any(e => e.IdComprobante == id);
        }
    }
}
